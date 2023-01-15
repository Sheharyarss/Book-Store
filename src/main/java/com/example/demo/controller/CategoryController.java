package com.example.demo.controller;


import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;



    @PostMapping("/category")
    public ResponseEntity<CategoryDto> postCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.postCategory(categoryDto));
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        return  ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PutMapping("/category/{id}")
    public  ResponseEntity<CategoryDto> updateCategoryById(@PathVariable Long id , @RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.updateCategoryById(id,categoryDto));
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) {

        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok().build();

    }
}

package com.example.demo.service;


import com.example.demo.dto.CategoryDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ModelMapper modelMapper;

    public CategoryDto postCategory(CategoryDto categoryDto) {

        Category category=modelMapper.map(categoryDto , Category.class);
        Category category1=categoryRepo.save(category);
        CategoryDto categoryDto1=modelMapper.map(category1 , CategoryDto.class);
        return categoryDto1;
    }

    public List<CategoryDto> getAllCategory() {
        List<Category> categoryList=categoryRepo.findAll();
        return categoryList.stream().map(category -> modelMapper.map(
                category , CategoryDto.class
        )).collect(Collectors.toList());
    }

    public CategoryDto getCategoryById(Long id) {
        Optional<Category> category=categoryRepo.findById(id);
        if(category.isPresent()){
            Category category1=category.get();
            CategoryDto categoryDto=modelMapper.map(category1 , CategoryDto.class);
            return categoryDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public CategoryDto updateCategoryById(Long id, CategoryDto categoryDto) {
        Optional<Category> category=categoryRepo.findById(id);
        if (category.isPresent()){
            Category category1=category.get();
            category1.setCategoryName(categoryDto.getCategoryName());
            Category category2=categoryRepo.save(category1);
            return modelMapper.map(category2 , CategoryDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteCategoryById(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        if (category.isPresent()) {
            categoryRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }
}

package com.example.demo.controller;


import com.example.demo.dto.AddressDto;
import com.example.demo.dto.AuthorDto;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {


    @Autowired
    AuthorService authorService;



    @PostMapping("/author")
    public ResponseEntity<AuthorDto> postAuthor(@RequestBody AuthorDto authorDto) {
        return ResponseEntity.ok(authorService.postAuthor(authorDto));
    }

    @GetMapping("/author")
    public ResponseEntity<List<AuthorDto>> getAllAuthor(){
        return  ResponseEntity.ok(authorService.getAllAuthor());
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id){
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PutMapping("/author/{id}")
    public  ResponseEntity<AuthorDto> updateAuthorById(@PathVariable Long id , @RequestBody AuthorDto authorDto){
        return ResponseEntity.ok(authorService.updateAuthorById(id,authorDto));
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<Void> deleteAuthorById(@PathVariable Long id) {

        authorService.deleteAuthorById(id);
        return ResponseEntity.ok().build();

    }

}

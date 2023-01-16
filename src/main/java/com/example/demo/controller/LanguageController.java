package com.example.demo.controller;

import com.example.demo.dto.InventoryDto;
import com.example.demo.dto.LanguageDto;
import com.example.demo.service.InventoryService;
import com.example.demo.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class LanguageController {

    @Autowired
    LanguageService languageService;



    @PostMapping("/language")
    public ResponseEntity<LanguageDto> postLanguage(@RequestBody LanguageDto languageDto) {
        return ResponseEntity.ok(languageService.postLanguage(languageDto));
    }

    @GetMapping("/language")
    public ResponseEntity<List<LanguageDto>> getAllLanguage(){
        return  ResponseEntity.ok(languageService.getAllLanguage());
    }

    @GetMapping("/language/{id}")
    public ResponseEntity<LanguageDto> getLanguageById(@PathVariable Long id){
        return ResponseEntity.ok(languageService.getLanguageById(id));
    }

    @PutMapping("/language/{id}")
    public  ResponseEntity<LanguageDto> updateLanguageById(@PathVariable Long id , @RequestBody LanguageDto languageDto){
        return ResponseEntity.ok(languageService.updateLanguageById(id,languageDto));
    }

    @DeleteMapping("/language/{id}")
    public ResponseEntity<Void> deleteLanguageById(@PathVariable Long id) {

        languageService.deleteLanguageById(id);
        return ResponseEntity.ok().build();

    }

}

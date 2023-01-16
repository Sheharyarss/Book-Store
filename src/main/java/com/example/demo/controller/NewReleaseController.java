package com.example.demo.controller;

import com.example.demo.dto.LanguageDto;
import com.example.demo.dto.NewReleaseDto;
import com.example.demo.service.LanguageService;
import com.example.demo.service.NewReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class NewReleaseController {

    @Autowired
    NewReleaseService newReleaseService;



    @PostMapping("/newRelease")
    public ResponseEntity<NewReleaseDto> postNewRelease(@RequestBody NewReleaseDto newReleaseDto) {
        return ResponseEntity.ok(newReleaseService.postNewRelease(newReleaseDto));
    }

    @GetMapping("/newRelease")
    public ResponseEntity<List<NewReleaseDto>> getAllNewRelease(){
        return  ResponseEntity.ok(newReleaseService.getAllNewRelease());
    }

    @GetMapping("/newRelease/{id}")
    public ResponseEntity<NewReleaseDto> getNewReleaseById(@PathVariable Long id){
        return ResponseEntity.ok(newReleaseService.getNewReleaseById(id));
    }

    @PutMapping("/newRelease/{id}")
    public  ResponseEntity<NewReleaseDto> updateNewReleaseById(@PathVariable Long id , @RequestBody NewReleaseDto newReleaseDto){
        return ResponseEntity.ok(newReleaseService.updateNewReleaseById(id,newReleaseDto));
    }

    @DeleteMapping("/newRelease/{id}")
    public ResponseEntity<Void> deleteNewReleaseById(@PathVariable Long id) {

        newReleaseService.deleteNewReleaseById(id);
        return ResponseEntity.ok().build();

    }




}

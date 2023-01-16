package com.example.demo.controller;


import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.DesignationDto;
import com.example.demo.service.CustomerService;
import com.example.demo.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DesignationController {

    @Autowired
    DesignationService designationService;



    @PostMapping("/designation")
    public ResponseEntity<DesignationDto> postDesignation(@RequestBody DesignationDto designationDto) {
        return ResponseEntity.ok(designationService.postDesignation(designationDto));
    }

    @GetMapping("/designation")
    public ResponseEntity<List<DesignationDto>> getAllDesignation(){
        return  ResponseEntity.ok(designationService.getAllDesignation());
    }

    @GetMapping("/designation/{id}")
    public ResponseEntity<DesignationDto> getDesignationById(@PathVariable Long id){
        return ResponseEntity.ok(designationService.getDesignationById(id));
    }

    @PutMapping("/designation/{id}")
    public  ResponseEntity<DesignationDto> updateDesignationById(@PathVariable Long id , @RequestBody DesignationDto designationDto){
        return ResponseEntity.ok(designationService.updateDesignationById(id,designationDto));
    }

    @DeleteMapping("/designation/{id}")
    public ResponseEntity<Void> deleteDesignationById(@PathVariable Long id) {

        designationService.deleteDesignationById(id);
        return ResponseEntity.ok().build();

    }
}

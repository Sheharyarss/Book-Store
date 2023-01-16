package com.example.demo.controller;

import com.example.demo.dto.PublisherDto;
import com.example.demo.dto.SalesDto;
import com.example.demo.service.PublisherService;
import com.example.demo.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SalesController {



    @Autowired
    SalesService salesService;

    @PostMapping("/sales")
    public ResponseEntity<SalesDto> postSales(@RequestBody SalesDto salesDto) {
        return ResponseEntity.ok(salesService.postSales(salesDto));
    }

    @GetMapping("/sales")
    public ResponseEntity<List<SalesDto>> getAllSales(){
        return  ResponseEntity.ok(salesService.getAllSales());
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<SalesDto> getSalesById(@PathVariable Long id){
        return ResponseEntity.ok(salesService.getSalesById(id));
    }

    @PutMapping("/sales/{id}")
    public  ResponseEntity<SalesDto> updateSalesById(@PathVariable Long id , @RequestBody SalesDto salesDto){
        return ResponseEntity.ok(salesService.updateSalesById(id,salesDto));
    }

    @DeleteMapping("/sales/{id}")
    public ResponseEntity<Void> deleteSalesById(@PathVariable Long id) {
        salesService.deleteSalesById(id);
        return ResponseEntity.ok().build();

    }

}

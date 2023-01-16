package com.example.demo.controller;

import com.example.demo.dto.PublisherDto;
import com.example.demo.dto.ShippingMethodDto;
import com.example.demo.service.PublisherService;
import com.example.demo.service.ShippingMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ShippingMethodController {

    @Autowired
    ShippingMethodService shippingMethodService;

    @PostMapping("/shippingMethod")
    public ResponseEntity<ShippingMethodDto> postShippingMethod(@RequestBody ShippingMethodDto shippingMethodDto) {
        return ResponseEntity.ok(shippingMethodService.postShippingMethod(shippingMethodDto));
    }

    @GetMapping("/shippingMethod")
    public ResponseEntity<List<ShippingMethodDto>> getAllShippingMethod(){
        return  ResponseEntity.ok(shippingMethodService.getAllShippingMethod());
    }

    @GetMapping("/shippingMethod/{id}")
    public ResponseEntity<ShippingMethodDto> getShippingMethodById(@PathVariable Long id){
        return ResponseEntity.ok(shippingMethodService.getShippingMethodById(id));
    }

    @PutMapping("/shippingMethod/{id}")
    public  ResponseEntity<ShippingMethodDto> updateShippingMethodById(@PathVariable Long id , @RequestBody ShippingMethodDto shippingMethodDto){
        return ResponseEntity.ok(shippingMethodService.updateShippingMethodById(id,shippingMethodDto));
    }

    @DeleteMapping("/shippingMethod/{id}")
    public ResponseEntity<Void> deleteShippingMethodById(@PathVariable Long id) {
        shippingMethodService.deleteShippingMethodById(id);
        return ResponseEntity.ok().build();

    }


}

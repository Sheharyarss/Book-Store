package com.example.demo.controller;

import com.example.demo.dto.GiftCardDto;
import com.example.demo.dto.InventoryDto;
import com.example.demo.service.GiftCardService;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class InventoryController {

    @Autowired
    InventoryService inventoryService;



    @PostMapping("/inventory")
    public ResponseEntity<InventoryDto> postInventory(@RequestBody InventoryDto inventoryDto) {
        return ResponseEntity.ok(inventoryService.postInventory(inventoryDto));
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<InventoryDto>> getAllInventory(){
        return  ResponseEntity.ok(inventoryService.getAllInventory());
    }

    @GetMapping("/inventory/{id}")
    public ResponseEntity<InventoryDto> getInventoryById(@PathVariable Long id){
        return ResponseEntity.ok(inventoryService.getInventoryById(id));
    }

    @PutMapping("/inventory/{id}")
    public  ResponseEntity<InventoryDto> updateInventoryById(@PathVariable Long id , @RequestBody InventoryDto inventoryDto){
        return ResponseEntity.ok(inventoryService.updateInventoryById(id,inventoryDto));
    }

    @DeleteMapping("/inventory/{id}")
    public ResponseEntity<Void> deleteInventoryById(@PathVariable Long id) {

        inventoryService.deleteInventoryById(id);
        return ResponseEntity.ok().build();

    }

}

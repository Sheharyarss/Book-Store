package com.example.demo.controller;


import com.example.demo.dto.BestSellerDto;
import com.example.demo.model.BestSeller;
import com.example.demo.service.BestSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BestSellerController {

    @Autowired
    BestSellerService bestSellerService;



    @PostMapping("/bestSeller")
    public ResponseEntity<BestSellerDto> postBestSeller(@RequestBody BestSellerDto bestSellerDto) {
        return ResponseEntity.ok(bestSellerService.postBestSeller(bestSellerDto));
    }

    @GetMapping("/bestSeller")
    public ResponseEntity<List<BestSellerDto>> getAllBestSeller(){
        return  ResponseEntity.ok(bestSellerService.getAllBestSeller());
    }

    @GetMapping("/bestSeller/{id}")
    public ResponseEntity<BestSellerDto> getBestSellerById(@PathVariable Long id){
        return ResponseEntity.ok(bestSellerService.getBestSellerById(id));
    }

    @PutMapping("/bestSeller/{id}")
    public  ResponseEntity<BestSellerDto> updateBestSellerById(@PathVariable Long id , @RequestBody BestSellerDto bestSellerDto){
        return ResponseEntity.ok(bestSellerService.updateBestSellerById(id,bestSellerDto));
    }

    @DeleteMapping("/bestSeller/{id}")
    public ResponseEntity<Void> deleteBestSellerById(@PathVariable Long id) {

        bestSellerService.deleteBestSellerById(id);
        return ResponseEntity.ok().build();

    }

}

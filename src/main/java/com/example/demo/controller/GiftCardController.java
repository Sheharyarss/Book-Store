package com.example.demo.controller;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.GiftCardDto;
import com.example.demo.service.CategoryService;
import com.example.demo.service.GiftCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GiftCardController {


    @Autowired
    GiftCardService giftCardService;



    @PostMapping("/giftCard")
    public ResponseEntity<GiftCardDto> postGiftCard(@RequestBody GiftCardDto giftCardDto) {
        return ResponseEntity.ok(giftCardService.postGiftCard(giftCardDto));
    }

    @GetMapping("/giftCard")
    public ResponseEntity<List<GiftCardDto>> getAllGiftCard(){
        return  ResponseEntity.ok(giftCardService.getAllGiftCard());
    }

    @GetMapping("/giftCard/{id}")
    public ResponseEntity<GiftCardDto> getGiftCardById(@PathVariable Long id){
        return ResponseEntity.ok(giftCardService.getGiftCardById(id));
    }

    @PutMapping("/giftCard/{id}")
    public  ResponseEntity<GiftCardDto> updateGiftCardById(@PathVariable Long id , @RequestBody GiftCardDto giftCardDto){
        return ResponseEntity.ok(giftCardService.updateGiftCardById(id,giftCardDto));
    }

    @DeleteMapping("/giftCard/{id}")
    public ResponseEntity<Void> deleteGiftCardById(@PathVariable Long id) {

        giftCardService.deleteGiftCardById(id);
        return ResponseEntity.ok().build();

    }

}

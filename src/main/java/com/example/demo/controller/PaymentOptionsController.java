package com.example.demo.controller;

import com.example.demo.dto.NewReleaseDto;
import com.example.demo.dto.PaymentOptionsDto;
import com.example.demo.service.NewReleaseService;
import com.example.demo.service.PaymentOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PaymentOptionsController {


    @Autowired
    PaymentOptionsService paymentOptionsService;

    @PostMapping("/paymentOptions")
    public ResponseEntity<PaymentOptionsDto> postPaymentOptions(@RequestBody PaymentOptionsDto paymentOptionsDto) {
        return ResponseEntity.ok(paymentOptionsService.postPaymentOptions(paymentOptionsDto));
    }

    @GetMapping("/paymentOptions")
    public ResponseEntity<List<PaymentOptionsDto>> getAllPaymentOptions(){
        return  ResponseEntity.ok(paymentOptionsService.getAllPaymentOptions());
    }

    @GetMapping("/paymentOptions/{id}")
    public ResponseEntity<PaymentOptionsDto> getPaymentOptionsById(@PathVariable Long id){
        return ResponseEntity.ok(paymentOptionsService.getPaymentOptionsById(id));
    }

    @PutMapping("/paymentOptions/{id}")
    public  ResponseEntity<PaymentOptionsDto> updatePaymentOptionsById(@PathVariable Long id , @RequestBody PaymentOptionsDto paymentOptionsDto){
        return ResponseEntity.ok(paymentOptionsService.updatePaymentOptionsById(id,paymentOptionsDto));
    }

    @DeleteMapping("/paymentOptions/{id}")
    public ResponseEntity<Void> deletePaymentOptionsById(@PathVariable Long id) {
        paymentOptionsService.deletePaymentOptionsById(id);
        return ResponseEntity.ok().build();

    }
}

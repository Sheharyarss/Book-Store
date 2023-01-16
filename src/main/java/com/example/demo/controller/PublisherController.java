package com.example.demo.controller;

import com.example.demo.dto.PaymentOptionsDto;
import com.example.demo.dto.PublisherDto;
import com.example.demo.service.PaymentOptionsService;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PublisherController {


    @Autowired
    PublisherService publisherService;

    @PostMapping("/publisher")
    public ResponseEntity<PublisherDto> postPublisher(@RequestBody PublisherDto publisherDto) {
        return ResponseEntity.ok(publisherService.postPublisher(publisherDto));
    }

    @GetMapping("/publisher")
    public ResponseEntity<List<PublisherDto>> getAllPublisher(){
        return  ResponseEntity.ok(publisherService.getAllPublisher());
    }

    @GetMapping("/publisher/{id}")
    public ResponseEntity<PublisherDto> getPublisherById(@PathVariable Long id){
        return ResponseEntity.ok(publisherService.getPublisherById(id));
    }

    @PutMapping("/publisher/{id}")
    public  ResponseEntity<PublisherDto> updatePublisherById(@PathVariable Long id , @RequestBody PublisherDto publisherDto){
        return ResponseEntity.ok(publisherService.updatePublisherById(id,publisherDto));
    }

    @DeleteMapping("/publisher/{id}")
    public ResponseEntity<Void> deletePublisherById(@PathVariable Long id) {
        publisherService.deletePublisherById(id);
        return ResponseEntity.ok().build();

    }

}

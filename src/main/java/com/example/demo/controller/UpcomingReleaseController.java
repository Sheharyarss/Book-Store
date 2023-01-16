package com.example.demo.controller;

import com.example.demo.dto.ShippingMethodDto;
import com.example.demo.dto.UpcomingReleaseDto;
import com.example.demo.service.ShippingMethodService;
import com.example.demo.service.UpcomingReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UpcomingReleaseController {



    @Autowired
    UpcomingReleaseService upcomingReleaseService;

    @PostMapping("/upcomingRelease")
    public ResponseEntity<UpcomingReleaseDto> postUpcomingRelease(@RequestBody UpcomingReleaseDto upcomingReleaseDto) {
        return ResponseEntity.ok(upcomingReleaseService.postUpcomingRelease(upcomingReleaseDto));
    }

    @GetMapping("/upcomingRelease")
    public ResponseEntity<List<UpcomingReleaseDto>> getAllUpcomingRelease(){
        return  ResponseEntity.ok(upcomingReleaseService.getAllUpcomingRelease());
    }

    @GetMapping("/upcomingRelease/{id}")
    public ResponseEntity<UpcomingReleaseDto> getUpcomingReleaseById(@PathVariable Long id){
        return ResponseEntity.ok(upcomingReleaseService.getUpcomingReleaseById(id));
    }

    @PutMapping("/upcomingRelease/{id}")
    public  ResponseEntity<UpcomingReleaseDto> updateUpcomingReleaseById(@PathVariable Long id , @RequestBody UpcomingReleaseDto upcomingReleaseDto){
        return ResponseEntity.ok(upcomingReleaseService.updateUpcomingReleaseById(id,upcomingReleaseDto));
    }

    @DeleteMapping("/upcomingRelease/{id}")
    public ResponseEntity<Void> deleteUpcomingReleaseById(@PathVariable Long id) {
        upcomingReleaseService.deleteUpcomingReleaseById(id);
        return ResponseEntity.ok().build();

    }

}

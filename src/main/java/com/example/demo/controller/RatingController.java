package com.example.demo.controller;



import com.example.demo.dto.RatingDto;
import com.example.demo.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class RatingController {

    @Autowired
    RatingService ratingService;



    @PostMapping("/rating")
    public ResponseEntity<RatingDto> postRating(@RequestBody RatingDto ratingDto) {
        return ResponseEntity.ok(ratingService.postRating(ratingDto));
    }

    @GetMapping("/rating")
    public ResponseEntity<List<RatingDto>> getAllRating(){
        return  ResponseEntity.ok(ratingService.getAllRating());
    }

    @GetMapping("/rating/{id}")
    public ResponseEntity<RatingDto> getRatingById(@PathVariable Long id){
        return ResponseEntity.ok(ratingService.getRatingById(id));
    }

    @PutMapping("/rating/{id}")
    public  ResponseEntity<RatingDto> updateRatingById(@PathVariable Long id , @RequestBody RatingDto ratingDto){
        return ResponseEntity.ok(ratingService.updateRatingById(id,ratingDto));
    }

    @DeleteMapping("/rating/{id}")
    public ResponseEntity<Void> deleteRatingById(@PathVariable Long id) {

        ratingService.deleteRatingById(id);
        return ResponseEntity.ok().build();

    }
}

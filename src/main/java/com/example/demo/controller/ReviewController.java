package com.example.demo.controller;


import com.example.demo.dto.ReviewsDto;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    ReviewService reviewService;



    @PostMapping("/review")
    public ResponseEntity<ReviewsDto> postReview(@RequestBody ReviewsDto reviewsDto) {
        return ResponseEntity.ok(reviewService.postReview(reviewsDto));
    }

    @GetMapping("/review")
    public ResponseEntity<List<ReviewsDto>> getAllReviews(){
        return  ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<ReviewsDto> getReviewById(@PathVariable Long id){
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @PutMapping("/review/{id}")
    public  ResponseEntity<ReviewsDto> updateReviewById(@PathVariable Long id , @RequestBody ReviewsDto reviewsDto){
        return ResponseEntity.ok(reviewService.updateReviewById(id,reviewsDto));
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<Void> deleteReviewById(@PathVariable Long id) {

        reviewService.deleteReviewById(id);
        return ResponseEntity.ok().build();

    }

}

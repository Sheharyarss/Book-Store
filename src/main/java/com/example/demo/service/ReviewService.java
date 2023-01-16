package com.example.demo.service;

import com.example.demo.dto.ReviewsDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Reviews;
import com.example.demo.repository.ReviewRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    ReviewRepo  reviewRepo;
    @Autowired
    ModelMapper modelMapper;

    public ReviewsDto postReview(ReviewsDto reviewsDto) {

        Reviews reviews=modelMapper.map(reviewsDto , Reviews.class);
        Reviews reviews1=reviewRepo.save(reviews);

        ReviewsDto reviewsDto1=modelMapper.map(reviews1 , ReviewsDto.class);
        return reviewsDto1;
    }

    public List<ReviewsDto> getAllReviews() {
        List<Reviews> reviewsList=reviewRepo.findAll();
        return reviewsList.stream().map(reviews -> modelMapper.map(
                reviews , ReviewsDto.class
        )).collect(Collectors.toList());
    }

    public ReviewsDto getReviewById(Long id) {
        Optional<Reviews> reviews=reviewRepo.findById(id);
        if(reviews.isPresent()){
            Reviews reviews1=reviews.get();
            ReviewsDto reviewsDto=modelMapper.map(reviews1 , ReviewsDto.class);
            return reviewsDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public ReviewsDto updateReviewById(Long id, ReviewsDto reviewsDto) {
        Optional<Reviews> reviews=reviewRepo.findById(id);
        if (reviews.isPresent()){
            Reviews reviews1=reviews.get();
            reviews1.setReview(reviewsDto.getReview());
            reviews1.setBookId(reviewsDto.getBookId());
            Reviews reviews2=reviewRepo.save(reviews1);
            return modelMapper.map(reviews2 , ReviewsDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }


    public void deleteReviewById(Long id) {
        Optional<Reviews> reviews = reviewRepo.findById(id);
        if (reviews.isPresent()) {
            reviewRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }
}

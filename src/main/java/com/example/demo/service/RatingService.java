package com.example.demo.service;

import com.example.demo.dto.DesignationDto;
import com.example.demo.dto.RatingDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Rating;
import com.example.demo.repository.RatingRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RatingService {

    @Autowired
    RatingRepo  ratingRepo;
    @Autowired
    ModelMapper modelMapper;

    public RatingDto postRating(RatingDto ratingDto) {

        Rating rating=modelMapper.map(ratingDto , Rating.class);
        Rating rating1=ratingRepo.save(rating);

        RatingDto ratingDto1=modelMapper.map(rating1 , RatingDto.class);
        return ratingDto1;
    }

    public List<RatingDto> getAllRating() {
        List<Rating> ratingList=ratingRepo.findAll();
        return ratingList.stream().map(rating -> modelMapper.map(
                rating , RatingDto.class
        )).collect(Collectors.toList());
    }

    public RatingDto getRatingById(Long id) {
        Optional<Rating> rating=ratingRepo.findById(id);
        if(rating.isPresent()){
            Rating rating1=rating.get();
            RatingDto ratingDto=modelMapper.map(rating1 , RatingDto.class);
            return ratingDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public RatingDto updateRatingById(Long id, RatingDto ratingDto) {
        Optional<Rating> rating=ratingRepo.findById(id);
        if (rating.isPresent()){
            Rating rating1=rating.get();
            rating1.setRating(ratingDto.getRating());
            Rating rating2=ratingRepo.save(rating1);
            return modelMapper.map(rating2 , RatingDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteRatingById(Long id) {
        Optional<Rating> rating = ratingRepo.findById(id);
        if (rating.isPresent()) {
            ratingRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }
}

package com.example.demo.dto;

import com.example.demo.model.Book;
import com.example.demo.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RatingDto  {

    private Integer  ratingId;
    private Integer  rating;


}

package com.example.demo.dto;


import com.example.demo.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookDto {

    private Long bookId;
    private String   title;
    private Language language_id;
    private Integer   num_pages;
    private Publisher publisher_id;
    private String   publication_date;
    private Category category_id;
    private Integer price;
    private Integer wholeSalePrice;
    private Author authorId;
    private Language  languageId;
    private Genre     genreId;
    private Discounts discountId;
    private Publisher publisherId;
}

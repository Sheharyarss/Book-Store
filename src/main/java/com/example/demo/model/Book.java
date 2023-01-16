package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String title;
    private Integer  num_pages;
//    private Publisher publisher_id;
    private String publication_date;

    private Integer price;
    private Integer wholeSalePrice;

    @ManyToOne
    private Author authorId;
    @ManyToMany
    private List<Language> languageId;
    @ManyToMany
    private List<Genre> genreId;
    @ManyToOne
    private Discounts discountId;
    @ManyToMany
    private List<Publisher> publisherId;
    @OneToOne
    private Rating rating;
}

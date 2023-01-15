package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter

@Entity
public class Genre {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;
    private String genreName;
    @OneToMany(mappedBy="categoryId")
    private List<Category> categoryId;

}

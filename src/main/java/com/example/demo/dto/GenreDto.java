package com.example.demo.dto;

import com.example.demo.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GenreDto {

    private Integer  genreId;
    private String genreName;
    private Category categoryId;
}

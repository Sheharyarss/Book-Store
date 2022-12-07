package com.example.demo.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter



public class BookDto {

    private String title;
    private String author;
    private String description;
}

package com.example.demo.dto;

import com.example.demo.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SalesDto{

    private Integer saleId;
    private Integer noOfSale;
    private Integer totalAmount;
    private Integer profit;
    private Book    bookId;
}

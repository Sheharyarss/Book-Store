package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Sales {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleId;
    private Integer noOfSale;
    private Integer totalAmount;
    private Integer profit;

    @OneToOne
    private Book bookId;
}

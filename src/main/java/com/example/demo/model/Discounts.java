package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity

public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;
    private Integer percentage;

}

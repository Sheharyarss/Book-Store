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
public class BestSeller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bestSellerId;

    @ManyToOne
    private Sales salesId;
}

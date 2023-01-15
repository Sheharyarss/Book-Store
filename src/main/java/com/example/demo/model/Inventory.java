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
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    private Integer inStock;
    private String status;

    @OneToOne
    private Book bookId;

}

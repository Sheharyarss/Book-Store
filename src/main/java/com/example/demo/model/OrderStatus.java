package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class OrderStatus {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderStatusId;
    private String statusValue;

    @OneToMany
    private List<Order> orderId;
}

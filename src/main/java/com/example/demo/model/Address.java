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
public class Address {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String address;
    private String city;


}

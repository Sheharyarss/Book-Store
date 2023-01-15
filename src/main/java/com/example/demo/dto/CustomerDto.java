package com.example.demo.dto;

import com.example.demo.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerDto {

    private Long customerId;
    private String firstName;
    private String lastName;
    private   String  email;
    private Address address;
}

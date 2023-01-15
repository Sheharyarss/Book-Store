package com.example.demo.dto;

import com.example.demo.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddressDto {
    private Long           addressId;
    private String         address;
    private String         city;

}

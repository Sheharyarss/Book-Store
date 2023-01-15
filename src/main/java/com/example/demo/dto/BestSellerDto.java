package com.example.demo.dto;

import com.example.demo.model.Sales;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BestSellerDto {
    private Integer id;
    private Sales salesId;
}

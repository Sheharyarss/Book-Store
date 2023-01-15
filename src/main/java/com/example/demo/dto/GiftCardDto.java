package com.example.demo.dto;

import com.example.demo.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GiftCardDto {

    private Integer  giftId;
    private String   gift;
    private Customer customerId;
}

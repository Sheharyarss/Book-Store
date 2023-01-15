package com.example.demo.dto;

import com.example.demo.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderDto {

    private Integer OrderId;
    private Book bookId;
    private Customer customerId;
    private Address addressId;
    private PaymentOptions optionId;
    private ShippingMethod methodId;

}

package com.example.demo.dto;

import com.example.demo.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderDto {

    private Integer    OrderId;
    private List<Book> bookId;
    private List<Customer>   customerId;
    private Address    addressId;
    private PaymentOptions paymentOptionId;
    private ShippingMethod methodId;

}

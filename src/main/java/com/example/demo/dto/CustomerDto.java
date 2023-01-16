package com.example.demo.dto;

import com.example.demo.model.Address;
import com.example.demo.model.GiftCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private List<GiftCard> giftCardId;

}

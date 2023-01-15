package com.example.demo.dto;

//import com.example.demo.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderStatusDto {

    private Integer statusId;
    private String  statusValue;
//    private Order   orderId;
}

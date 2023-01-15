package com.example.demo.dto;

//import com.example.demo.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderHistoryDto {

    private Integer   historyId;
    private   LocalDate orderDate;
    private   LocalDate dispatchedDate;
    private LocalDate deliveredDate;
//    private Order     orderId;
}

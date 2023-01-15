package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderHistoryId;
    private LocalDate orderDate;
    private LocalDate dispatchedDate;
    private LocalDate deliveredDate;

//    @ManyToOne
//    private Order orderId;
}

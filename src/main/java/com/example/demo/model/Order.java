//package com.example.demo.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Data
//
//@Entity
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long orderId;
//    @ManyToMany
//    private List<Book> bookId;
//    @ManyToMany
//    private List<Customer> customerId;
//    @OneToMany
//    private List<Address> addressId;
//    @ManyToOne
//    private PaymentOptions paymentOptions;
//    @ManyToOne
//    private ShippingMethod methodId;
//}

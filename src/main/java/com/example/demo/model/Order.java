package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "order_book" ,
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> bookId;
    @ManyToMany
    @JoinTable(name = "order_customer" ,
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customerId;
    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address addressId;
    @ManyToOne
    @JoinColumn(name = "paymentOptionsId")
    private PaymentOptions paymentOptions;
    @ManyToOne
    @JoinColumn(name = "shippingMethodId")
    private ShippingMethod methodId;
}

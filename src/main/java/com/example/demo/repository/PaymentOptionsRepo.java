package com.example.demo.repository;

import com.example.demo.model.PaymentOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentOptionsRepo extends JpaRepository<PaymentOptions,Long> {
}

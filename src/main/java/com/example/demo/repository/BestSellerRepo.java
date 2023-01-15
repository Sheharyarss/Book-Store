package com.example.demo.repository;


import com.example.demo.model.BestSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestSellerRepo extends JpaRepository<BestSeller , Long> {
}

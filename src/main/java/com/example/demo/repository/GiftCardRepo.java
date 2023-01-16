package com.example.demo.repository;

import com.example.demo.model.GiftCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface GiftCardRepo extends JpaRepository<GiftCard,Long> {

}

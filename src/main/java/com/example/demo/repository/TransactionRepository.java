package com.example.demo.repository;

import com.example.demo.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findAllByAccountId(Long accId);
    Optional<Transaction> findByUniqueId(UUID uuid);
}

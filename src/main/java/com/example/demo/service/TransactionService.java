package com.example.demo.service;


import com.example.demo.domain.Account;
import com.example.demo.domain.Player;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.dto.TransactionDTO;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.exception.InvalidAmountException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import jdk.nashorn.internal.ir.IfNode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ModelMapper modelMapper;
    @Transactional
    public TransactionDTO creditTransaction(TransactionDTO transactionDTO, Long id) {
        Transaction transaction = todo(transactionDTO);
        Account account = accountService.playerPresentById(id);
        if (uuidIsUnique(transaction.getUniqueId())){
        if(transaction.getAmount() > 0){
            Transaction newTransaction = Transaction.builder()
                                        .amount(transaction.getAmount())
                                        .uniqueId(transaction.getUniqueId())
                    .dateTime(LocalDateTime.now()).type("CREDIT")
                                        .account(account)
                                        .build();
            Transaction trans = transactionRepository.save(newTransaction);
            account.setBalance(account.getBalance() + transaction.getAmount());
//            account.getTransactions().add(trans);
            accountRepository.save(account);
            TransactionDTO transactionDTO1 = todto(trans);
            return transactionDTO1;}
        else {
            throw new InvalidAmountException(String.format("Insufficient Amount! => %d", id));}}
        else{ throw new AlreadyExistsException(String.format("Transaction is invalid => %d", id));} }

    public TransactionDTO debitTransaction(TransactionDTO transactionDTO, Long id) {
        Transaction transaction = todo(transactionDTO);
        Account account = accountService.playerPresentById(id);
        if (uuidIsUnique(transaction.getUniqueId())){
        if(transaction.getAmount() <= account.getBalance()){
            Transaction newTransaction = Transaction.builder()
                    .amount(transaction.getAmount())
                    .uniqueId(transaction.getUniqueId())
                    .dateTime(LocalDateTime.now()).type("DEBIT")
                    .account(account)
                    .build();
            Transaction trans = transactionRepository.save(newTransaction);
            account.setBalance(account.getBalance() - transaction.getAmount());
            //account.getTransactions().add(trans);
            accountRepository.save(account);
            TransactionDTO transactionDTO1 = todto(trans);
            return transactionDTO1;}
        else{ throw new InvalidAmountException(String.format("Insufficient Funds => %d", id));}}
    else {
            throw new AlreadyExistsException(String.format("Transaction is invalid => %d", id));
        }}

    public List<Transaction> getAllTransaction(Long id) {
        Account account = accountService.playerPresentById(id);
        Long accId = account.getId();
        List<Transaction> transactions = transactionRepository.findAllByAccountId(accId);
        return transactions;}
    public Transaction todo(TransactionDTO transactionDTO){
        return modelMapper.map(transactionDTO,Transaction.class);
    }
    public TransactionDTO todto(Transaction transaction){
        return modelMapper.map(transaction,TransactionDTO.class);
    }



    private Boolean uuidIsUnique(UUID uuid) {
        Optional<Transaction> uniqueId = transactionRepository.findByUniqueId(uuid);
        if (uniqueId.isPresent()){
            return false;
        }else {
            return true;
        }}

}


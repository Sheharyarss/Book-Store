package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.domain.Player;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public void createAccount(Player savedPlayer) {
//        Account account = new Account();
//        account.setBalance(0.00);
//        account.setPlayer(savedPlayer);
        Account acc = Account.builder().balance(0.00).player(savedPlayer).build();
        accountRepository.save(acc);}

    public ResponseEntity<Double> getBalance(Long id) {
        Double balance= playerPresentById(id).getBalance();
        return ResponseEntity.ok(balance);}

    public Account playerPresentById(Long id) {
        Optional<Account> account = accountRepository.findByPlayerId(id);
        if (account.isPresent()){
            return account.get();}
        else {
            throw new RecordNotFoundException(String.format("Player does not exists on id => %d",id));}}
}


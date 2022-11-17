package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;



    /**
     * this function get the balance of account from player id
     * @param id
     * @return
     */
    public Double getBalance(Long id) {
        Double balance= playerPresentById(id).getBalance();
        return balance;}

    /**
     * this function will check for the player which is present on the subsequent player id
     * @param id
     * @return
     */

    public Account playerPresentById(Long id) {
        Optional<Account> account = accountRepository.findByPlayerId(id);
        if (account.isPresent()){
            return account.get();}
        else {
            throw new RecordNotFoundException(String.format("Player does not exists on id => %d",id));}}

}


package com.example.demo.service;


import com.example.demo.domain.Account;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.TransactionDTO;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.exception.InvalidAmountException;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ModelMapper modelMapper;


    /**
     *this function will make credit transaction and check for a unique transaction id and add amount into your account balance
     * @param transactionDTO
     * @param id
     * @return
     */
    @Transactional
    public TransactionDTO creditTransaction(TransactionDTO transactionDTO, Long id) {
        Account account = playerPresentById(id);
        if (uuidIsUnique(transactionDTO.getUniqueId())){
        if(transactionDTO.getAmount() > 0){
            Transaction newTransaction = Transaction.builder()
                                        .amount(transactionDTO.getAmount())
                                        .uniqueId(transactionDTO.getUniqueId())
                    .dateTime(LocalDateTime.now()).type("CREDIT")
                                        .account(account)
                                        .build();
            Transaction trans = transactionRepository.save(newTransaction);
            account.setBalance(account.getBalance() + trans.getAmount());
//            account.getTransactions().add(trans);
            accountRepository.save(account);
            return todto(trans);}
        else {
            throw new InvalidAmountException(String.format("Insufficient Amount! => %f", transactionDTO.getAmount()));}}
        else{ throw new AlreadyExistsException(String.format("Transaction is invalid => %d", id));} }

    /**
     * this function will make debit transaction and check for a unique transaction id and deduct amount from your account balance
     * if the sufficient amount is present
     * @param transactionDTO
     * @param id
     * @return
     */
    public TransactionDTO debitTransaction(TransactionDTO transactionDTO, Long id) {
        Account account = playerPresentById(id);
        if (uuidIsUnique(transactionDTO.getUniqueId())){
        if(transactionDTO.getAmount() <= account.getBalance()){
            Transaction newTransaction = Transaction.builder()
                    .amount(transactionDTO.getAmount())
                    .uniqueId(transactionDTO.getUniqueId())
                    .dateTime(LocalDateTime.now()).type("DEBIT")
                    .account(account)
                    .build();
            Transaction trans = transactionRepository.save(newTransaction);
            account.setBalance(account.getBalance() - trans.getAmount());
            //account.getTransactions().add(trans);
            accountRepository.save(account);
            return todto(trans);}
        else{ throw new InvalidAmountException(String.format("Insufficient Funds => %f", transactionDTO.getAmount()));}}
    else {
            throw new AlreadyExistsException(String.format("Transaction is invalid => %d", id));
        }}


    /**
     * this function will provide a list of transaction on the subsequent player id given
     * also checks if the player is present by this id
     * @param id
     * @return
     */
    public List<Transaction> getAllTransaction(Long id) {
        Account account = playerPresentById(id);
        Long accId = account.getId();
        List<Transaction> transactions = transactionRepository.findAllByAccountId(accId);
        return transactions;}

    public Transaction todo(TransactionDTO transactionDTO){
        return modelMapper.map(transactionDTO,Transaction.class);
    }
    public TransactionDTO todto(Transaction transaction){
        return modelMapper.map(transaction,TransactionDTO.class);
    }

    /**
     * this function will make sure that the transaction id is unique or not
     * @param uuid
     * @return
     */
    private Boolean uuidIsUnique(UUID uuid) {
        Optional<Transaction> uniqueId = transactionRepository.findByUniqueId(uuid);
        if (uniqueId.isPresent()){
            return false;
        }else {
            return true;
        }}

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


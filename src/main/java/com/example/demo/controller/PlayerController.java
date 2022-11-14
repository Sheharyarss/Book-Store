package com.example.demo.controller;

import com.example.demo.domain.Transaction;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.dto.TransactionDTO;
import com.example.demo.service.AccountService;
import com.example.demo.service.PlayerService;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @Autowired
    AccountService accountService;

    @Autowired
    TransactionService transactionService;

    @PostMapping("/save")
    public ResponseEntity<PlayerDTO> registerPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
        return ResponseEntity.ok(playerService.savePlayer(playerDTO));}

    @GetMapping("balance/{id}")
    public ResponseEntity<Double> getBalanceById(@PathVariable Long id){
        return ResponseEntity.ok(accountService.getBalance(id));
    }

    @PostMapping("credit/{id}")
    public ResponseEntity<TransactionDTO> creditAmount(@Valid @RequestBody TransactionDTO transactionDTO, @PathVariable Long id ){
        return ResponseEntity.ok(transactionService.creditTransaction(transactionDTO,id));}

    @PostMapping("debit/{id}")
    public ResponseEntity<TransactionDTO> debitAmount(@Valid @RequestBody TransactionDTO transactionDTO,@PathVariable Long id){
        return ResponseEntity.ok(transactionService.debitTransaction(transactionDTO,id));}

    @GetMapping("transaction/{id}")
    public ResponseEntity<List<Transaction>> allTransaction(@PathVariable Long id){
        return ResponseEntity.ok(transactionService.getAllTransaction(id));}
}

package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.domain.Player;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
     @Autowired
     PlayerRepository playerRepository;

     @Autowired
     AccountRepository accountRepository;

     @Autowired
    ModelMapper modelMapper;

    /**
     * this function saves the player with unique email and creates an account respect to your player id
     * @param playerDTO
     * @return
     */

    public PlayerDTO savePlayer(PlayerDTO playerDTO) {

        if (isNotUniqueEmail(playerDTO.getEmail())){
            throw new AlreadyExistsException(String.format("User Already exists on email => %s",playerDTO.getEmail()));
        }else {
         Player savedPlayer =  playerRepository.save(todo(playerDTO));
         Account acc = Account.builder().balance(0.00).player(savedPlayer).build();
            accountRepository.save(acc);
         return todto(savedPlayer);
        }}


    public Boolean isNotUniqueEmail(String email){
        Optional<String> email2 = playerRepository.findByEmail(email);
        if (email2.isPresent()){
              return true;}
        else {
              return false;}}

    public Player todo(PlayerDTO playerDTO){
        return modelMapper.map(playerDTO,Player.class);
    }
    public PlayerDTO todto(Player player){
        return modelMapper.map(player,PlayerDTO.class);
    }
}

package com.example.demo.service;

import com.example.demo.domain.Player;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.exception.AlreadyExistsException;
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
     AccountService accountService;

     @Autowired
    ModelMapper modelMapper;

    public PlayerDTO save(PlayerDTO playerDTO) {
        Player player = todo(playerDTO);
        String email = player.getEmail();
        if (emailIsPresent(email)){
            throw new AlreadyExistsException(String.format("User Already exists on email => %s",email));
        }else {
         Player savedPlayer =  playerRepository.save(player);
         PlayerDTO playerDTO1=todto(savedPlayer);
         accountService.createAccount(savedPlayer);
         return playerDTO1;
        }}


    public Boolean emailIsPresent(String email){
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

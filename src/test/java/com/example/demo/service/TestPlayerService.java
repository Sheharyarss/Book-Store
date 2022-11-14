package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.domain.Player;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.PlayerRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestPlayerService {

    @Mock
    PlayerRepository playerRepository;

    @Mock
    AccountRepository accountRepository;

    @Spy
    ModelMapper modelMapper = new ModelMapper();

    @InjectMocks
    PlayerService playerService;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldSavePlayer(){
        PlayerDTO playerDTO = PlayerDTO.builder()
                                .id(1L)
                .firstName("test")
                .lastName("tester")
                .email("test@test.com")
                                .build();

        Player player = Player.builder()
                        .id(1L)
                .firstName("test")
                .lastName("tester")
                .email("test@test.com")
                        .build();

        Account account = Account.builder()
                        .id(1L)
                .balance(0.00)
                .player(player)
                        .build();

        Mockito.when(playerRepository.findByEmail(any())).thenReturn(Optional.empty());
        Mockito.when(playerRepository.save(any())).thenReturn(player);
        Mockito.when(accountRepository.save(account)).thenReturn(account);
        PlayerDTO saved = playerService.savePlayer(playerDTO);
        assertEquals(saved.getEmail(),playerDTO.getEmail());
        assertEquals(saved.getFirstName(),playerDTO.getFirstName());
        assertEquals(saved.getLastName(),playerDTO.getLastName());
    }

    @Test(expected = AlreadyExistsException.class)
    public void shouldThrowExceptionWhenPlayerEmailAlreadyExsist(){
        PlayerDTO playerDTO = PlayerDTO.builder()
                .id(1L)
                .firstName("test")
                .lastName("tester")
                .email("test@test.com")
                .build();


        Mockito.when(playerRepository.findByEmail(any())).thenReturn(Optional.of(playerDTO.getEmail()));

        PlayerDTO result = playerService.savePlayer(playerDTO);
    }
}

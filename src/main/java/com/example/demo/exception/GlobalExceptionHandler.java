package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> emailConflictException(AlreadyExistsException ex){
        ErrorMessage errorMessage = ErrorMessage.builder().body(ex.getMessage()).code(HttpStatus.CONFLICT)
                .timeStamp(LocalDateTime.now()).build();
        return new ResponseEntity(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(RecordNotFoundException ex){
        ErrorMessage errorMessage = ErrorMessage.builder().body(ex.getMessage()).code(HttpStatus.NOT_FOUND)
                .timeStamp(LocalDateTime.now()).build();
        return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = InvalidAmountException.class)
    public ResponseEntity<ErrorMessage> invalidTransactionAmountException(InvalidAmountException ex){
        ErrorMessage errorMessage = ErrorMessage.builder().body(ex.getMessage()).code(HttpStatus.BAD_REQUEST)
                .timeStamp(LocalDateTime.now()).build();
        return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
    Map<String,String> response = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach(er->{
        String fieldName = ((FieldError)er).getField();
        String message = er.getDefaultMessage();
        response.put(fieldName,message);
    });


    return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
    }

    }

package com.example.demo.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = DoesNotExist.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(DoesNotExist rnf) {
        ErrorMessage errorMessage=ErrorMessage.builder().
                body(rnf.getMessage())
                .localDateTime(LocalDateTime.now()).
                build();
        return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
    }


}

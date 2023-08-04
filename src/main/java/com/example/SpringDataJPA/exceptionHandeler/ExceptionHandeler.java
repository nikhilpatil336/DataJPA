package com.example.SpringDataJPA.exceptionHandeler;

import com.example.SpringDataJPA.exception.ResourceNotFoundException;
import com.example.SpringDataJPA.responseDTO.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandeler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ExceptionResponse> resourceNotFoundExcetionHandeler(ResourceNotFoundException ex)
    {
        return new ResponseEntity<ExceptionResponse>(ExceptionResponse.builder().message(ex.getMessage()).build(),HttpStatus.NOT_FOUND);
    }
}

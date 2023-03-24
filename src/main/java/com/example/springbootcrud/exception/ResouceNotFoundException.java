package com.example.springbootcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)     //HTTP response status code with custom exception
public class ResouceNotFoundException extends RuntimeException{

    public ResouceNotFoundException(String message){
        super(message);

    }
}

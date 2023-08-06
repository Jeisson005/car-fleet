package com.agence.carfleet.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class RestException extends RuntimeException{

    private HttpStatus status;

    public RestException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
    
}

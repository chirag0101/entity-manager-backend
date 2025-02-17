package com.iris.entitymanager.exceptions;


import org.springframework.web.bind.MethodArgumentNotValidException;

public class GlobalException extends RuntimeException {
    public GlobalException(String message){
        super(message);
    }
}
package com.iris.entitymanager.exceptions;


public class InvalidEntityNameException extends RuntimeException {
    public InvalidEntityNameException(String message){
        super(message);
    }
}
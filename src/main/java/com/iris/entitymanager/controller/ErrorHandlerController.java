package com.iris.entitymanager.controller;

import com.iris.entitymanager.entity.ErrorResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {
    @ExceptionHandler
    public ResponseEntity<ErrorResponseEntity> handleException(Exception e) {
        ErrorResponseEntity errorResponse=new ErrorResponseEntity();
        errorResponse.setStatus(false);
        errorResponse.setStatusCode("E001");
        errorResponse.setStatusMessage(e.getMessage());
        errorResponse.setResponse(null);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

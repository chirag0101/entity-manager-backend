package com.iris.entitymanager.controller;

import com.iris.entitymanager.entity.ErrorResponseEntity;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseEntity> handleException(ConstraintViolationException e) {
        ErrorResponseEntity errorResponse=new ErrorResponseEntity();
        errorResponse.setStatus(false);
        errorResponse.setStatusCode("E001");
        String errorMessage = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage) // Extract message from validation
                .findFirst()
                .orElse("Validation failed due to invalid input");

        errorResponse.setStatusMessage(errorMessage);
        errorResponse.setStatusMessage(e.getMessage());
        errorResponse.setResponse(null);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseEntity> handleDatabaseException(DataIntegrityViolationException e) {
        ErrorResponseEntity errorResponse = new ErrorResponseEntity();
        errorResponse.setStatus(false);
        errorResponse.setStatusCode("E001");

        if(e.getMessage().contains("ENTITY_NAME")) {
            errorResponse.setStatusMessage(e.getMessage());
        } else {
            // Avoid returning low-level DB details; show user-friendly message
            errorResponse.setStatusMessage(e.getMessage());
        }
        errorResponse.setResponse(null);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseEntity> handleException(Exception e) {
        ErrorResponseEntity errorResponse = new ErrorResponseEntity();
        errorResponse.setStatus(false);
        errorResponse.setStatusCode("E001");
        errorResponse.setStatusMessage("An error occurred: " + e.getMessage());
        errorResponse.setResponse(null);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

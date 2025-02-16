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
                .map(ConstraintViolation::getMessage)
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

        if(e.getMessage().toUpperCase().contains("ENTITY_NAME") ) {
            errorResponse.setStatusMessage(e.getMessage());
        }else if(e.getMessage().contains("ORA-02290") && e.getMessage().toUpperCase().contains("ENTITY_SHORT_NAME") ){
            errorResponse.setStatusMessage("Invalid Entity Short Name!");
        }else if(e.getMessage().contains("ORA-02290") && e.getMessage().toUpperCase().contains("ENTITY_CODE") ){
            errorResponse.setStatusMessage("Invalid Entity Code!");
        }else if(e.getMessage().contains("ORA-02290") && e.getMessage().contains("COM_TYPE_ID")){
            errorResponse.setStatusMessage("Invalid Com Type Id!");
        }else if(e.getMessage().contains("ORA-02290") && e.getMessage().toUpperCase().contains("CATEGORY_ID")){
            errorResponse.setStatusMessage("Invalid Category Id!");
        }else if(e.getMessage().contains("ORA-02290") && e.getMessage().toUpperCase().contains("SUB_CATEGORY_ID") ){
            errorResponse.setStatusMessage("Invalid Sub Category Id!");
        }else if(e.getMessage().contains("ORA-02290") && e.getMessage().toUpperCase().contains("ENTITY_EMAIL_ID") ){
            errorResponse.setStatusMessage("Invalid Email Id!");
        }else if(e.getMessage().contains("ORA-02290") && e.getMessage().toUpperCase().contains("CREATED_BY") ){
            errorResponse.setStatusMessage("Invalid Entry for Created By");
        }else if(e.getMessage().contains("LAST_MODIFIED_BY")){
            errorResponse.setStatusMessage("Invalid Entry for Last Modified By!");
        }else if(e.getMessage().contains("ENTITY_PHONE_NO")){
            errorResponse.setStatusMessage("Invalid Entity Phone No. !");
        }else if(e.getMessage().contains("BANK_TYPE")){
            errorResponse.setStatusMessage("Invalid Bank Type!");
        }else {
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

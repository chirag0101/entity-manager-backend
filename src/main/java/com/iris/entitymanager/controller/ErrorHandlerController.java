package com.iris.entitymanager.controller;

import com.iris.entitymanager.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {
    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleException(Exception e) {
        ApiResponse errorResponse=new ApiResponse();

        errorResponse.setStatus(false);
        errorResponse.setStatusCode("E001");


        if(e.getMessage().contains("E001")){
            errorResponse.setStatusMessage("Entity Name can't be empty!");
        }else if(e.getMessage().contains("E002")){
            errorResponse.setStatusMessage("Entity Short Name can't be empty!");
        }else if(e.getMessage().contains("E003")){
            errorResponse.setStatusMessage("Entity Code can't be empty!");
        }else if(e.getMessage().contains("P001")){
            errorResponse.setStatusMessage("Invalid Entity Name!");
        }else if(e.getMessage().contains("P002")){
            errorResponse.setStatusMessage("Invalid Entity Short Name!");
        }else if(e.getMessage().contains("P003")){
            errorResponse.setStatusMessage("Invalid Entity Code!");
        }else if(e.getMessage().contains("P004")){
            errorResponse.setStatusMessage("Invalid Email Id!");
        }else if(e.getMessage().contains("P004")){
            errorResponse.setStatusMessage("Invalid Phone No.!");
        }else{
            errorResponse.setStatusMessage(e.getMessage());
        }

        //errorResponse.setStatusMessage(e.getMessage());
        errorResponse.setResponse(null);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

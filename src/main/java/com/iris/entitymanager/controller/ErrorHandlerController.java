package com.iris.entitymanager.controller;

import com.iris.entitymanager.config.KeyLoader;
import com.iris.entitymanager.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {
    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleException(Exception e) {
        ApiResponse errorResponse = new ApiResponse();

        errorResponse.setStatus(false);
        for (String errorInDb : KeyLoader.error.keySet()) {
            System.out.println(errorInDb);

            if(e.getMessage().contains(errorInDb)){
                errorResponse.setStatusCode(errorInDb);
                errorResponse.setStatusMessage(errorInDb);
            }
        }
//        errorResponse.setStatusCode(e.getMessage());
        errorResponse.setStatusMessage(KeyLoader.error.get(errorResponse.getStatusMessage()));
        errorResponse.setResponse(null);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

package com.iris.entitymanager.controller;

import com.iris.entitymanager.dto.ApiResponse;
import com.iris.entitymanager.listener.ErrorLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ErrorHandlerController {
    @Autowired
    private ErrorLoader errorLoader;

    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleException(Exception e) {
        ApiResponse errorResponse = new ApiResponse();

        errorResponse.setStatus(false);

        System.out.println("Exception: " + e.getMessage());

        String invalidValue = e.getMessage();

        if (!invalidValue.matches("-?\\d+")) {
            errorResponse.setStatusCode("P012");
            errorResponse.setStatusMessage(errorLoader.errors.get("P012"));
        } else {
            errorLoader.errors.forEach((k, v) -> {
                        if (e.getMessage().contains(k)) {
                            errorResponse.setStatusCode(k);
                            errorResponse.setStatusMessage(v);
                        }
                    }
            );
        }

        errorResponse.setResponse(null);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse> handleArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        ApiResponse errorResponse = new ApiResponse();
        errorResponse.setStatus(false);

        errorResponse.setStatusCode("E404");  // Bad Request
        errorResponse.setStatusMessage(errorLoader.errors.get("E404"));

        errorResponse.setResponse(null);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

package com.iris.entitymanager.dto;

import java.util.List;

public class ApiResponse<T> {
    private boolean status = true;
    private String statusCode = "00";
    private String statusMessage = "Success";
    private List<T> response = null;

    public ApiResponse() {
    }

    public ApiResponse(List<T> response){
        this.response=response;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public List<?> getResponse() {
        return response;
    }

    public void setResponse(List<T> response) {
        this.response = response;
    }
}

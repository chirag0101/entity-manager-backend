package com.iris.entitymanager.dto;

public class ApiResponse {
    private boolean status=true;
    private String statusCode="00";
    private String statusMessage="Success";
    private EntityDto response=null;

    public ApiResponse(){}

    public ApiResponse(EntityDto EntityDto){
        this.response=EntityDto;
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

    public EntityDto getResponse() {
        return response;
    }

    public void setResponse(EntityDto response) {
        this.response = response;
    }
}

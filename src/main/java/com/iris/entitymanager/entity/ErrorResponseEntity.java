package com.iris.entitymanager.entity;

import com.iris.entitymanager.dto.EntityRequestDto;
import jakarta.persistence.Entity;

public class ErrorResponseEntity {
    private boolean status=true;
    private String statusCode="00";
    private String statusMessage="Success";
    private EntityRequestDto response=null;

    public ErrorResponseEntity(){}

    public ErrorResponseEntity(EntityRequestDto entityRequestDto){
        this.response=entityRequestDto;
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

    public EntityRequestDto getResponse() {
        return response;
    }

    public void setResponse(EntityRequestDto response) {
        this.response = response;
    }
}

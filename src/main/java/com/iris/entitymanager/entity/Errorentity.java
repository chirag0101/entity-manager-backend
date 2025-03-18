package com.iris.entitymanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ERROR_KEYS")
public class Errorentity {

    @Id
    @Column(name = "ERROR_CODE")
    private String errorCode;

    @Column(name = "ERROR_STATUS")
    private String errorMessage;

    public Errorentity() {
    }

    public Errorentity(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

package com.iris.entitymanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_RETURN_TYPE")
public class ReturnTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RETURN_TYPE_ID")
    private Long returnTypeId;

    @Column(name = "RETURN_TYPE_DESC")
    private String returnTypeDesc;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    public ReturnTypeEntity(){}

    public ReturnTypeEntity(Long returnTypeId, String returnTypeDesc, Boolean isActive) {
        this.returnTypeId = returnTypeId;
        this.returnTypeDesc = returnTypeDesc;
        this.isActive = isActive;
    }

    public Long getReturnTypeId() {
        return returnTypeId;
    }

    public void setReturnTypeId(Long returnTypeId) {
        this.returnTypeId = returnTypeId;
    }

    public String getReturnTypeDesc() {
        return returnTypeDesc;
    }

    public void setReturnTypeDesc(String returnTypeDesc) {
        this.returnTypeDesc = returnTypeDesc;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}

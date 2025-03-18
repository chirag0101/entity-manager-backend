package com.iris.entitymanager.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TBL_RETURN_RETURN_TYPE")
public class ReturnReturnTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RETURN_RETURN_TYPE_ID")
    private Long returnReturnTypeId;

    @OneToOne
    @JoinColumn(name = "RETURN_ID")
    private ReturnEntity returnIdFk;

    @OneToOne
    @JoinColumn(name = "RETURN_TYPE_ID")
    private ReturnType returnTypeIdFk;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "MODIFIED_ON")
    private Date modifiedOn;

    @Column(name = "MODIFIED_BY")
    private Long modifiedBy;

    public ReturnReturnTypeEntity() {
    }

    public ReturnReturnTypeEntity(Long returnReturnTypeId, ReturnEntity returnIdFk, ReturnType returnTypeIdFk, Boolean isActive, Date modifiedOn, Long modifiedBy) {
        this.returnReturnTypeId = returnReturnTypeId;
        this.returnIdFk = returnIdFk;
        this.returnTypeIdFk = returnTypeIdFk;
        this.isActive = isActive;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
    }

    public Long getReturnReturnTypeId() {
        return returnReturnTypeId;
    }

    public void setReturnReturnTypeId(Long returnReturnTypeId) {
        this.returnReturnTypeId = returnReturnTypeId;
    }

    public ReturnEntity getReturnIdFk() {
        return returnIdFk;
    }

    public void setReturnIdFk(ReturnEntity returnIdFk) {
        this.returnIdFk = returnIdFk;
    }

    public ReturnType getReturnTypeIdFk() {
        return returnTypeIdFk;
    }

    public void setReturnTypeIdFk(ReturnType returnTypeIdFk) {
        this.returnTypeIdFk = returnTypeIdFk;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
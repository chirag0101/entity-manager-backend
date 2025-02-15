package com.iris.entitymanager.dto;

import jakarta.validation.constraints.*;

import java.util.Date;

public class EntityRequestDto {

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z1-9.&]{200}$",message = "Invalid Entity Name")
    @Size(min=1, max=200)
    private String entityName;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z1-9.&]{100}$",message = "Invalid Entity Short Name")
    @Size(min=1, max=100)
    private String entityShortname;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9.&]$",message = "Invalid Entitiy Code")
    @Size(min=4, max=24)
    private String entityCode;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9.&]$",message = "Invalid IFSC Code")
    @Size(min=4, max=24)
    private String ifscCode;

    @NotEmpty
    private String comTypeId="3";

    @NotEmpty
    @Min(0)
    @Max(99)
    private int categoryId;

    @NotEmpty
    @Min(0)
    @Max(99)
    private int subCategoryId;

    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$",message = "Invalid Email id")
    private String entityEmailId;

    @NotEmpty
    private int createdBy;

    @NotEmpty
    private int lastModifiedBy;

    @Pattern(regexp = "^(\\\\+\\\\d{1,4})?\\\\d{10,15}$")
    private String entityPhoneNo;

    @NotEmpty
    private String entityNameBil=entityName;

    @NotEmpty
    private String entityShortName=entityShortname;

    @NotEmpty
    private int bankType;

    public EntityRequestDto(){

    }

    public EntityRequestDto(String entityName, String entityShortname, String entityCode, String ifscCode, String comTypeId, int categoryId, int subCategoryId, String entityEmailId, int createdBy, int lastModifiedBy, String entityPhoneNo, String entityNameBil, String entityShortName, int bankType) {
        this.entityName = entityName;
        this.entityShortname = entityShortname;
        this.entityCode = entityCode;
        this.ifscCode = ifscCode;
        this.comTypeId = comTypeId;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.entityEmailId = entityEmailId;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.entityPhoneNo = entityPhoneNo;
        this.entityNameBil = entityNameBil;
        this.entityShortName = entityShortName;
        this.bankType = bankType;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setEntityShortname(String entityShortname) {
        this.entityShortname = entityShortname;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public void setComTypeId(String comTypeId) {
        this.comTypeId = comTypeId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public void setEntityEmailId(String entityEmailId) {
        this.entityEmailId = entityEmailId;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public void setLastModifiedBy(int lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setEntityPhoneNo(String entityPhoneNo) {
        this.entityPhoneNo = entityPhoneNo;
    }

    public void setEntityNameBil(String entityNameBil) {
        this.entityNameBil = entityNameBil;
    }

    public void setEntityShortName(String entityShortName) {
        this.entityShortName = entityShortName;
    }

    public void setBankType(int bankType) {
        this.bankType = bankType;
    }

}

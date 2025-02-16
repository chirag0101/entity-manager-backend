package com.iris.entitymanager.dto;

import jakarta.validation.constraints.*;

public class EntityRequestDto {

    @NotEmpty(message = "Entity Name Can't be Empty")
    @Size(min = 1, max = 200, message = "Entity Name size must be between 1 and 200")
    @Pattern(regexp = "^[a-zA-Z1-9.&]{1,200}$")
    @Size(min=1, max=200)
    private String entityName;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z1-9.&]{1,100}$")
    @Size(min=1, max=100)
    private String entityShortName;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9.&]{1,200}$")
    @Size(min=4, max=24)
    private String entityCode;

    private int comTypeId=3;

    @NotNull
    @Min(value = 0, message = "CATEGORY_ID")
    @Max(value=99,message = "CATEGORY_ID")
    private int categoryId;

    @NotNull
    @Min(0)
    @Max(99)
    private int subCategoryId;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
    private String entityEmailId;

    @NotNull
    @Min(0)
    private int createdBy;

    @NotNull
    private int lastModifiedBy;

    @Pattern(regexp = "^(\\+\\d{1,4})?\\d{10,15}$", message = "Invalid Phone Number")
    private String entityPhoneNo;

    @NotNull
    private int bankType;

    public EntityRequestDto(){}

    public EntityRequestDto(String entityName, String entityShortName, String entityCode, int comTypeId, int categoryId, int subCategoryId, String entityEmailId, int createdBy, int lastModifiedBy, String entityPhoneNo, int bankType) {
        this.entityName = entityName;
        this.entityShortName = entityShortName;
        this.entityCode = entityCode;
        this.comTypeId = comTypeId;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.entityEmailId = entityEmailId;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.entityPhoneNo = entityPhoneNo;
        this.bankType = bankType;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityShortName() {
        return entityShortName;
    }

    public void setEntityShortName(String entityShortName) {
        this.entityShortName = entityShortName;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public int getComTypeId() {
        return comTypeId;
    }

    public void setComTypeId(int comTypeId) {
        this.comTypeId = comTypeId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getEntityEmailId() {
        return entityEmailId;
    }

    public void setEntityEmailId(String entityEmailId) {
        this.entityEmailId = entityEmailId;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(int lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getEntityPhoneNo() {
        return entityPhoneNo;
    }

    public void setEntityPhoneNo(String entityPhoneNo) {
        this.entityPhoneNo = entityPhoneNo;
    }

    public int getBankType() {
        return bankType;
    }

    public void setBankType(int bankType) {
        this.bankType = bankType;
    }
}

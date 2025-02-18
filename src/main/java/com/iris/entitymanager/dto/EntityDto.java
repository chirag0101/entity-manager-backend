package com.iris.entitymanager.dto;

import jakarta.validation.constraints.*;

public class EntityDto {

    //  @NotEmpty(message = "Entity Name Can't be Empty")
    @NotEmpty(message = "E001")
    @Pattern(regexp = "^[a-zA-Z1-9.&]{1,200}$", message = "P001")
    private String entityName;

    //  @NotEmpty(message = "Entity Short Name can't be empty")
    @NotEmpty(message = "E002")
    @Pattern(regexp = "^[a-zA-Z1-9.&]{1,100}$", message = "P002")
    private String entityShortName;

    //  @NotEmpty(message = "Entity Code can't be empty")
    @NotEmpty(message = "E003")
    @Pattern(regexp = "^[a-zA-Z0-9.&]{4,24}$", message = "P003!")
    private String entityCode;

    @NotNull(message = "N001")
    private int comTypeId = 3;

    @NotNull(message = "N002")
    @Min(value = 0, message = "Category_Id less than 0!")
    @Max(value = 99, message = "Category_Id more than 99!")
    private int categoryId;

    @NotNull(message = "N003")
    @Min(value = 0, message = "P007")
    @Max(value = 99, message = "P008")
    private int subCategoryId;

    @Email(message = "P004")
    private String entityEmailId;

    @NotNull(message = "N004")
    @Min(value = 0, message = "P006")
    private int createdBy;

    @NotNull(message = "N005")
    private int lastModifiedBy;

    @Pattern(regexp = "^(\\+\\d{1,4})?\\d{10,15}$", message = "P005")
    private String entityPhoneNo;

    @NotNull(message = "N006")
    private int bankType;

    public EntityDto() {
    }

    public EntityDto(String entityName, String entityShortName, String entityCode, int comTypeId, int categoryId, int subCategoryId, String entityEmailId, int createdBy, int lastModifiedBy, String entityPhoneNo, int bankType) {
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


    /*error codes:
        notEmpty:
            E001
            E002
            E003
        pattern:
            P001
            P002
            P003
            P004
            P005
        notNull:
            N001
            N002
            N003
            N004
            N005
            N006
    */
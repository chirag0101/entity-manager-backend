package com.iris.entitymanager.dto;

import jakarta.validation.constraints.*;

public class EntityDto {

    @NotEmpty(message = "E001")
    @Pattern(regexp = "^[a-zA-Z1-9.&\\s]{1,200}$", message = "P001")
    private String entityName;

    @NotEmpty(message = "E002")
    @Pattern(regexp = "^[a-zA-Z1-9.&\\s]{1,100}$", message = "P002")
    private String entityShortName;

    @NotEmpty(message = "E003")
    @Pattern(regexp = "^[a-zA-Z0-9.&\\s]{4,24}$", message = "P003")    //change
    private String entityCode;

    @NotNull(message = "N002")
    @Min(value = 0, message = "P005")
    @Max(value = 99, message = "P005")
    private int categoryId;

    @NotNull(message = "N003")
    @Min(value = 0, message = "P006")
    @Max(value = 99, message = "P006")
    private int subCategoryId;

    @Email(message = "P007")
    private String entityEmailId;

    @NotNull(message = "N004")
    @Min(value = 0, message = "P008")
    private int createdBy;

    @NotNull(message = "N005")
    @Min(value = 0, message = "P009")
    private Integer lastModifiedBy;

    @Pattern(regexp = "^(\\+\\d{1,4})?\\d{10,15}$", message = "P0010")
    private String entityPhoneNo;

    @NotNull(message = "N006")
    @Min(value = 0, message = "P0011")
    private int bankType;

    @NotEmpty(message = "E007")
    @Pattern(regexp = "^[a-zA-Z1-9.&\\s]{1,100}$", message = "P013")
    private String label;


    public EntityDto() {
    }

    public EntityDto(String entityName, String entityShortName, String entityCode, int categoryId, int subCategoryId, String entityEmailId, int createdBy, Integer lastModifiedBy, String entityPhoneNo, int bankType, String label) {
        this.entityName = entityName;
        this.entityShortName = entityShortName;
        this.entityCode = entityCode;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.entityEmailId = entityEmailId;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.entityPhoneNo = entityPhoneNo;
        this.bankType = bankType;
        this.label=label;
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

    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
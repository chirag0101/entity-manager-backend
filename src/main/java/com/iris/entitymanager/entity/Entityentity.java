package com.iris.entitymanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TBL_ENTITY")
public class Entityentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENTITY_ID")
    private Integer id;

    @Column(name = "ENTITY_NAME")
    private String entityName;

    @Column(name = "ENTITY_SHORT_NAME")
    private String entityShortName;

    @Column(name = "ENTITY_CODE")
    private String entityCode;

    @Column(name = "IFSC_CODE")
    private String ifscCode;

    @Column(name = "COMP_TYPE_ID")
    private int compTypeId;

    @Column(name = "CATEGORY_ID")
    private int categoryId;

    @Column(name = "SUB_CATEGORY_ID")
    private int subCategoryId;

    @Column(name = "ENTITY_EMAIL_ID")
    private String entityEmailId;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    @Column(name = "CREATED_BY")
    private int createdBy;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "LAST_MODIFIED_BY")
    @JsonIgnore //to ignore lastModifiedBy while converting object to json for storing in TBL_ENTITY_MOD
    private Integer lastModifiedBy;

    @Column(name = "LAST_MODIFIED_ON")
    @JsonIgnore
    private Date lastModifiedOn;

    @Column(name = "ENTITY_PHONE_NO")
    private String entityPhoneNo;

    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @Column(name = "ENTITY_NAME_BIL")
    private String entityNameBil;

    @Column(name = "ENTITY_SHORT_NAME_BIL")
    private String entityShortNameBil;

    @Column(name = "BANK_TYPE")
    private int bankType;

    @Column(name = "LABEL")
    private String label;

    public Entityentity() {

    }

    public Entityentity(Integer id, String entityName, String entityShortName, String label, String entityCode, int compTypeId, int categoryId, int subCategoryId, String entityEmailId, boolean isActive, int createdBy, Date createdOn, int lastModifiedBy, Date lastModifiedOn, String entityPhoneNo, Date updatedOn, int bankType) {
        this.id = id;
        this.entityName = entityName;
        this.entityShortName = entityShortName;
        this.entityCode = entityCode;
        this.ifscCode = entityCode;
        this.compTypeId = compTypeId;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.entityEmailId = entityEmailId;
        this.isActive = isActive;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedOn = lastModifiedOn;
        this.entityPhoneNo = entityPhoneNo;
        this.updatedOn = updatedOn;
        this.entityNameBil = entityName;
        this.entityShortNameBil = entityShortName;
        this.bankType = bankType;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public int getCompTypeId() {
        return compTypeId;
    }

    public void setCompTypeId(int comTypeId) {
        this.compTypeId = comTypeId;
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedOn() {
        return this.lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public String getEntityPhoneNo() {
        return entityPhoneNo;
    }

    public void setEntityPhoneNo(String entityPhoneNo) {
        this.entityPhoneNo = entityPhoneNo;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getEntityNameBil() {
        return entityNameBil;
    }

    public void setEntityNameBil(String entityNameBil) {
        this.entityNameBil = entityNameBil;
    }

    public String getEntityShortNameBil() {
        return entityShortNameBil;
    }

    public void setEntityShortNameBil(String entityShortNameBil) {
        this.entityShortNameBil = entityShortNameBil;
    }

    public int getBankType() {
        return bankType;
    }

    public void setBankType(int bankType) {
        this.bankType = bankType;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Entityentity{" +
                "id=" + id +
                ", entityName='" + entityName + '\'' +
                ", entityShortName='" + entityShortName + '\'' +
                ", entityCode='" + entityCode + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", compTypeId=" + compTypeId +
                ", categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
                ", entityEmailId='" + entityEmailId + '\'' +
                ", isActive=" + isActive +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", lastModifiedBy=" + lastModifiedBy +
                ", lastModifiedOn=" + lastModifiedOn +
                ", entityPhoneNo='" + entityPhoneNo + '\'' +
                ", updatedOn=" + updatedOn +
                ", entityNameBil='" + entityNameBil + '\'' +
                ", entityShortNameBil='" + entityShortNameBil + '\'' +
                ", bankType=" + bankType +
                ", label='" + label + '\'' +
                '}';
    }
}
package com.iris.entitymanager.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_ENTITY")
public class Entityentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "ENTITY_NAME")
    private String entityName;

    @Column(name = "ENTITY_SHORT_NAME")
    private String entityShortname;

    @Column(name = "ENTITY_CODE")
    private String entityCode;

    @Column(name = "IFSC_CODE")
    private String ifscCode;

    @Column(name = "COM_TYPE_ID")
    private String comTypeId;

    @Column(name = "CATEGORY_ID")
    private String categoryId;

    @Column(name = "SUB_CATEGORY_ID")
    private String subCategoryId;

    @Column(name = "ENTITY_EMAIL_ID")
    private String entityEmailId;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    @Column(name = "CREATED_BY")
    private int createdBy;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "LAST_MODIFIED_BY")
    private int lastModifiedBy;

    @Column(name = "LAST_MODIFIED_ON")
    private Date lastModifiedOn;

    @Column(name = "ENTITY_PHONE_NO")
    private String entityPhoneNo;

    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @Column(name = "ENTITY_NAME_BIL")
    private String entityNameBil;

    @Column(name = "ENTITY_SHORT_NAME_BIL")
    private String entityShortName;

    @Column(name = "BANK_TYPE")
    private int bankType;

    public String getComTypeId() {
        return comTypeId;
    }

    public void setComTypeId(String comTypeId) {
        this.comTypeId = comTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityShortname() {
        return entityShortname;
    }

    public void setEntityShortname(String entityShortname) {
        this.entityShortname = entityShortname;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getEntityEmailId() {
        return entityEmailId;
    }

    public void setEntityEmailId(String entityEmailId) {
        this.entityEmailId = entityEmailId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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

    public int getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(int lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
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

    public String getEntityShortName() {
        return entityShortName;
    }

    public void setEntityShortName(String entityShortName) {
        this.entityShortName = entityShortName;
    }

    public int getBankType() {
        return bankType;
    }

    public void setBankType(int bankType) {
        this.bankType = bankType;
    }
}

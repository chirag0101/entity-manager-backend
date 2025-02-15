package com.iris.entitymanager.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_ENTITY")
public class Entityentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ENTITY_NAME")
    private String entityName;

    @Column(name = "ENTITY_SHORT_NAME")
    private String entityShortName;

    @Column(name = "ENTITY_CODE")
    private String entityCode;

    @Column(name = "IFSC_CODE")
    private String ifscCode;

    @Column(name = "COM_TYPE_ID")
    private String comTypeId;

    @Column(name = "CATEGORY_ID")
    private int categoryId;

    @Column(name = "SUB_CATEGORY_ID")
    private int subCategoryId;

    @Column(name = "ENTITY_EMAIL_ID")
    private String entityEmailId;

    @Column(name = "IS_ACTIVE")
    private boolean isActive=true;

    @Column(name = "CREATED_BY")
    private int createdBy;

    @Column(name = "CREATED_ON")
    private Date createdOn=new Date();

    @Column(name = "LAST_MODIFIED_BY")
    private int lastModifiedBy;

    @Column(name = "LAST_MODIFIED_ON")
    private Date lastModifiedOn=new Date();

    @Column(name = "ENTITY_PHONE_NO")
    private String entityPhoneNo;

    @Column(name = "UPDATED_ON")
    private Date updatedOn=new Date();

    @Column(name = "ENTITY_NAME_BIL")
    private String entityNameBil;

    @Column(name = "ENTITY_SHORT_NAME_BIL")
    private String entityShortNameBil;

    @Column(name = "BANK_TYPE")
    private int bankType;

    public Entityentity(){

    }

    public Entityentity(Integer id, String entityName, String entityShortName, String entityCode, String ifscCode, String comTypeId, int categoryId, int subCategoryId, String entityEmailId, boolean isActive, int createdBy, Date createdOn, int lastModifiedBy, Date lastModifiedOn, String entityPhoneNo, Date updatedOn, String entityNameBil, String entityShortNameBil, int bankType) {
        this.id = id;
        this.entityName = entityName;
        this.entityShortName = entityShortName;
        this.entityCode = entityCode;
        this.ifscCode = ifscCode;
        this.comTypeId = comTypeId;
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
        this.entityNameBil = entityNameBil;
        this.entityShortNameBil = entityShortNameBil;
        this.bankType = bankType;
    }

    public Integer getId() {
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

    public String getComTypeId() {
        return comTypeId;
    }

    public void setComTypeId(String comTypeId) {
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
}

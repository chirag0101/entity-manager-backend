package com.iris.entitymanager.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TBL_ENTITY")
//@SequenceGenerator(name = "my_sequence", sequenceName = "MY_SEQ", allocationSize = 1)
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
    private String entityShortNameBil;

    @Column(name = "BANK_TYPE")
    private int bankType;

    // Cascade settings for related child entities (TBL_ENTITY_MOD)
    @OneToMany(mappedBy = "entityIdFk", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntityModentity> entityMods = new ArrayList<>();

    public Entityentity() {

    }

    public Entityentity(Integer id, String entityName, String entityShortName, String entityCode, int compTypeId, int categoryId, int subCategoryId, String entityEmailId, boolean isActive, int createdBy, Date createdOn, int lastModifiedBy, Date lastModifiedOn, String entityPhoneNo, Date updatedOn, int bankType) {
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

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getIfscCode() {return ifscCode;}

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

    public void setIsActive(boolean isActive) {this.isActive = isActive;}

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

    public List<EntityModentity> getEntityMods() {return entityMods;}

    public void setEntityMods(List<EntityModentity> entityMods) {this.entityMods = entityMods;}

    @Override
    public String toString() {
        return "{" +
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
                '}';
    }
}
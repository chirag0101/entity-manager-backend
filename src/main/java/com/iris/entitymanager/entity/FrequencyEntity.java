package com.iris.entitymanager.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TBL_FREQUENCY")
public class FrequencyEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FREQUENCY_ID")
    private Long frequencyId;

    @Column(name = "FREQUENCY_NAME")
    private String frequencyName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @OneToOne
    @JoinColumn(name = "CREATED_BY_FK")
    private UserEntity createdByFk;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @ManyToOne
    @JoinColumn(name = "LAST_MODIFIED_BY_FK")
    private UserEntity lastModifiedByFk;

    @Column(name = "LAST_MODIFIED_ON")
    private Date lastModifiedOn;

    @ManyToOne
    @JoinColumn(name = "LAST_APPROVED_BY_FK")
    private UserEntity lastApprovedByFk;

    @Column(name = "LAST_APPROVED_ON")
    private Date lastApprovedOn;

    @Column(name = "LAST_UPDATE_ON")
    private Date lastUpdateOn;

    @Column(name = "FREQUENCY_CODE")
    private String frequencyCode;

    public FrequencyEntity() {
    }

    public FrequencyEntity(Long frequencyId, String frequencyName, String description, Boolean isActive, UserEntity createdByFk, Date createdOn, UserEntity lastModifiedByFk, Date lastModifiedOn, UserEntity lastApprovedByFk, Date lastApprovedOn, Date lastUpdateOn, String frequencyCode) {
        this.frequencyId = frequencyId;
        this.frequencyName = frequencyName;
        this.description = description;
        this.isActive = isActive;
        this.createdByFk = createdByFk;
        this.createdOn = createdOn;
        this.lastModifiedByFk = lastModifiedByFk;
        this.lastModifiedOn = lastModifiedOn;
        this.lastApprovedByFk = lastApprovedByFk;
        this.lastApprovedOn = lastApprovedOn;
        this.lastUpdateOn = lastUpdateOn;
        this.frequencyCode = frequencyCode;
    }

    public Long getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(Long frequencyId) {
        this.frequencyId = frequencyId;
    }

    public String getFrequencyName() {
        return frequencyName;
    }

    public void setFrequencyName(String frequencyName) {
        this.frequencyName = frequencyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public UserEntity getCreatedByFk() {
        return createdByFk;
    }

    public void setCreatedByFk(UserEntity createdByFk) {
        this.createdByFk = createdByFk;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public UserEntity getLastModifiedByFk() {
        return lastModifiedByFk;
    }

    public void setLastModifiedByFk(UserEntity lastModifiedByFk) {
        this.lastModifiedByFk = lastModifiedByFk;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public UserEntity getLastApprovedByFk() {
        return lastApprovedByFk;
    }

    public void setLastApprovedByFk(UserEntity lastApprovedByFk) {
        this.lastApprovedByFk = lastApprovedByFk;
    }

    public Date getLastApprovedOn() {
        return lastApprovedOn;
    }

    public void setLastApprovedOn(Date lastApprovedOn) {
        this.lastApprovedOn = lastApprovedOn;
    }

    public Date getLastUpdateOn() {
        return lastUpdateOn;
    }

    public void setLastUpdateOn(Date lastUpdateOn) {
        this.lastUpdateOn = lastUpdateOn;
    }

    public String getFrequencyCode() {
        return frequencyCode;
    }

    public void setFrequencyCode(String frequencyCode) {
        this.frequencyCode = frequencyCode;
    }
}
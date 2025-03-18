package com.iris.entitymanager.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TBL_RETURN_MOD")
public class ReturnMod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RETURN_MOD_ID")
    private Long modId;

    @ManyToOne
    @JoinColumn(name = "RETURN_ID_FK")
    private ReturnEntity returnIdFk;

    @Column(name = "LAST_MODIFIED_BY")
    private Long lastModifiedBy;

    @Column(name = "PREV_DATA_JSON")
    private String prevDataJson;

    @Column(name = "LAST_MODIFIED_ON")
    private Date lastModifiedOn;

    public ReturnMod(){}

    public ReturnMod(Long modId, ReturnEntity returnIdFk, Long lastModifiedBy, String prevDataJson, Date lastModifiedOn) {
        this.modId = modId;
        this.returnIdFk = returnIdFk;
        this.lastModifiedBy = lastModifiedBy;
        this.prevDataJson = prevDataJson;
        this.lastModifiedOn = lastModifiedOn;
    }

    public Long getModId() {
        return modId;
    }

    public void setModId(Long modId) {
        this.modId = modId;
    }

    public ReturnEntity getReturnIdFk() {
        return returnIdFk;
    }

    public void setReturnIdFk(ReturnEntity returnIdFk) {
        this.returnIdFk = returnIdFk;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getPrevDataJson() {
        return prevDataJson;
    }

    public void setPrevDataJson(String prevDataJson) {
        this.prevDataJson = prevDataJson;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }
}
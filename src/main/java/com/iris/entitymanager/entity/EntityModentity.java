package com.iris.entitymanager.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TBL_ENTITY_MOD")
public class EntityModentity {

    @Id
    @Column(name = "ENTITY_MOD_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_mod_seq")
    @SequenceGenerator(name = "entity_mod_seq", sequenceName = "SEQ_ENTITY_MOD_ID", allocationSize = 1)
    private int entityModId;

    @ManyToOne
    @JoinColumn(name = "ENTITY_ID_FK")
    private Entityentity entityIdFk;

    @Column(name = "LAST_MODIFIED_BY_FK")
    private Integer lastModifiedByFk;

    @Column(name = "LAST_MODIFIED_ON")
    private Date lastModifiedOn;

    @Lob
    @Column(name = "PREV_DATA_JSON")
    private String prevDataJson;

    public EntityModentity() {

    }

    public EntityModentity(int entityModId, Entityentity entityIdFk, Integer lastModifiedByFk, Date lastModifiedOn, String prevDataJson) {
        this.entityModId = entityModId;
        this.entityIdFk = entityIdFk;
        this.lastModifiedByFk = lastModifiedByFk;
        this.lastModifiedOn = lastModifiedOn;
        this.prevDataJson = prevDataJson;
    }

    public int getEntityModId() {
        return entityModId;
    }

    public void setEntityModId(int entityModId) {
        this.entityModId = entityModId;
    }

    public Entityentity getEntityIdFk() {
        return entityIdFk;
    }

    public void setEntityIdFk(Entityentity entityIdFk) {
        this.entityIdFk = entityIdFk;
    }

    public Integer getLastModifiedByFk() {
        return lastModifiedByFk;
    }

    public void setLastModifiedByFk(Integer lastModifiedByFk) {
        this.lastModifiedByFk = lastModifiedByFk;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public String getPrevDataJson() {
        return prevDataJson;
    }

    public void setPrevDataJson(String prevDataJson) {
        this.prevDataJson = prevDataJson;
    }
}

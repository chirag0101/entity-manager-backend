package com.iris.entitymanager.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TBL_ENTITY_MOD")
public class EntityModentity {
    //    @Id

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENC)
    @Column(name = "ENTITY_MOD_ID")
    private int entityModId;

    //    @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "ENTITY_ID_FK", referencedColumnName = "ENTITY_ID")
    private Entityentity entityIdFk;

    @ManyToOne
    @JoinColumn(name = "LAST_MODIFIED_BY_FK", referencedColumnName = "LAST_MODIFIED_BY")
    private Entityentity lastModifiedByFk;

    @Column(name = "LAST_MODIFIED_ON")
    private Date lastModifiedOn;

    @Lob
    private String prevDataJson;

    public EntityModentity() {

    }

    public EntityModentity(int entityModId, Entityentity entityIdFk, Entityentity lastModifiedByFk, Date lastModifiedOn, String prevDataJson) {
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

    public Entityentity getLastModifiedByFk() {
        return lastModifiedByFk;
    }

    public void setLastModifiedByFk(Entityentity entityLastModifiedByFk) {
        this.lastModifiedByFk = entityLastModifiedByFk;
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

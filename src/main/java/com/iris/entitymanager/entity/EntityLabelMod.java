package com.iris.entitymanager.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TBL_ENTITY_LABEL_MOD")
public class EntityLabelMod {

    @Id
    @Column(name = "LABEL_MOD_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_mod_seq")
    @SequenceGenerator(name = "entity_mod_seq", sequenceName = "SEQ_ENTITY_MOD_ID", allocationSize = 1)
    private int labelModEntityId;

    @ManyToOne
    @JoinColumn(name = "LABEL_ID_FK")
    private EntityLabel entityLabelIdFk;

    @Column(name = "LABEL_LAST_MODIFIED_BY")
    private Integer lastModifiedByFk;

    @Lob
    @Column(name = "LABEL_PREV_DATA")
    private String prevDataJson;

    @Column(name = "LABEL_LAST_MODIFIED_ON")
    private Date lastModifiedOn;

    public EntityLabelMod() {
    }

    public EntityLabelMod(int labelModEntityId, EntityLabel entityLabelIdFk, Integer lastModifiedByFk, String prevDataJson, Date lastModifiedOn) {
        this.labelModEntityId = labelModEntityId;
        this.entityLabelIdFk = entityLabelIdFk;
        this.lastModifiedByFk = lastModifiedByFk;
        this.prevDataJson = prevDataJson;
        this.lastModifiedOn = lastModifiedOn;
    }

    public int getLabelModEntityId() {
        return labelModEntityId;
    }

    public void setLabelModEntityId(int labelModEntityId) {
        this.labelModEntityId = labelModEntityId;
    }

    public EntityLabel getEntityLabelIdFk() {
        return entityLabelIdFk;
    }

    public void setEntityLabelIdFk(EntityLabel entityLabelIdFk) {
        this.entityLabelIdFk = entityLabelIdFk;
    }

    public Integer getLastModifiedByFk() {
        return lastModifiedByFk;
    }

    public void setLastModifiedByFk(Integer lastModifiedByFk) {
        this.lastModifiedByFk = lastModifiedByFk;
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

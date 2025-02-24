package com.iris.entitymanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_ENTITY_LABEL")
public class EntityLabelentity {

    @Id
    @Column(name = "ENTITY_LABEL_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_mod_seq")
    @SequenceGenerator(name = "entity_mod_seq", sequenceName = "SEQ_ENTITY_MOD_ID", allocationSize = 1)
    private int labelEntityId;

    @ManyToOne
    @JoinColumn(name = "ENTITY_ID_FK")
    @JsonIgnore
    private Entityentity entityIdFk;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "LAST_MODIFIED_BY")
    @JsonIgnore
    private Integer lastModifiedBy;

    @Column(name = "LAST_MODIFIED_ON")
    @JsonIgnore
    private Date lastModifiedOn;

    @Column(name = "LANG_ID_FK")
    private Integer langIdFk;

    public EntityLabelentity(){}

    public EntityLabelentity(int labelEntityId, Entityentity entityIdFk, String label, Integer lastModifiedBy, Date lastModifiedOn, Integer langIdFk) {
        this.labelEntityId = labelEntityId;
        this.entityIdFk = entityIdFk;
        this.label = label;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedOn = lastModifiedOn;
        this.langIdFk = langIdFk;
    }

    public int getLabelEntityId() {
        return labelEntityId;
    }

    public void setLabelEntityId(int labelEntityId) {
        this.labelEntityId = labelEntityId;
    }

    public Entityentity getEntityIdFk() {
        return entityIdFk;
    }

    public void setEntityIdFk(Entityentity entityIdFk) {
        this.entityIdFk = entityIdFk;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public Integer getLangIdFk() {
        return langIdFk;
    }

    public void setLangIdFk(Integer langIdFk) {
        this.langIdFk = langIdFk;
    }
}

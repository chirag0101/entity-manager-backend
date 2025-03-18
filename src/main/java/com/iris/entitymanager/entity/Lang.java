package com.iris.entitymanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "TBL_LANG")
public class Lang {
    @Id
    @Column(name = "LANG_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_mod_seq")
    @SequenceGenerator(name = "entity_mod_seq", sequenceName = "SEQ_ENTITY_MOD_ID", allocationSize = 1)
    private Integer langId;

    @Column(name = "IS_ACTIVE")
    @JsonIgnore
    private boolean isActive = true;

    @Column(name = "LANG")
    private String language;

    public Lang() {

    }

    public Lang(Integer langId, Integer labelIdFk, boolean isActive, String language) {
        this.langId = langId;
        this.isActive = isActive;
        this.language = language;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}

package com.iris.entitymanager.entity;

import jakarta.persistence.*;

@Entity
public class LangEntity {
    @Id
    @Column(name = "LANG_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_mod_seq")
    @SequenceGenerator(name = "entity_mod_seq", sequenceName = "SEQ_ENTITY_MOD_ID", allocationSize = 1)
    private Integer langId;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "LANG")
    private String language;

    public LangEntity(){

    }

    public LangEntity(Integer langId, Boolean isActive, String language) {
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}

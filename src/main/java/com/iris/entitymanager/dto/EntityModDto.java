package com.iris.entitymanager.dto;

import com.iris.entitymanager.entity.EntityMod;

import java.util.List;

public class EntityModDto {
    private EntityDto entityDto;

    private List<EntityMod> entityModentities;

    public EntityModDto() {

    }

    public EntityModDto(EntityDto entityDto, List<EntityMod> entityModentities) {
        this.entityDto = entityDto;
        this.entityModentities = entityModentities;
    }

    public EntityDto getEntityDto() {
        return entityDto;
    }

    public void setEntityDto(EntityDto entityDto) {
        this.entityDto = entityDto;
    }

    public List<EntityMod> getEntityModentities() {
        return entityModentities;
    }

    public void setEntityModentities(List<EntityMod> entityModentities) {
        this.entityModentities = entityModentities;
    }
}

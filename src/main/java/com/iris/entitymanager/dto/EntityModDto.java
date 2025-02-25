package com.iris.entitymanager.dto;

import com.iris.entitymanager.entity.EntityModentity;

import java.util.List;

public class EntityModDto {
    private EntityDto entityDto;

    private List<EntityModentity> entityModentities;

    public EntityModDto(){

    }

    public EntityModDto(EntityDto entityDto, List<EntityModentity> entityModentities) {
        this.entityDto = entityDto;
        this.entityModentities = entityModentities;
    }

    public EntityDto getEntityDto() {
        return entityDto;
    }

    public void setEntityDto(EntityDto entityDto) {
        this.entityDto = entityDto;
    }

    public List<EntityModentity> getEntityModentities() {
        return entityModentities;
    }

    public void setEntityModentities(List<EntityModentity> entityModentities) {
        this.entityModentities = entityModentities;
    }
}

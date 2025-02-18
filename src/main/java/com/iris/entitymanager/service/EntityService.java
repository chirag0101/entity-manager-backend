package com.iris.entitymanager.service;

import com.iris.entitymanager.dto.EntityDto;
import com.iris.entitymanager.entity.Entityentity;
import com.iris.entitymanager.dto.ApiResponse;
import com.iris.entitymanager.exceptions.GlobalException;
import com.iris.entitymanager.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EntityService {

    @Autowired
    private EntityRepository entityRepository;

    //create new entity entry - done
    @Transactional
    public ResponseEntity<?> createNewEntity(EntityDto EntityDto) {
        try {
            Entityentity entity = new Entityentity();

            entity.setEntityName(EntityDto.getEntityName());
            entity.setEntityShortName(EntityDto.getEntityShortName());
            entity.setEntityCode(EntityDto.getEntityCode());
            entity.setIfscCode(EntityDto.getEntityCode());
            entity.setComTypeId(EntityDto.getComTypeId());
            entity.setCategoryId(EntityDto.getCategoryId());
            entity.setSubCategoryId(EntityDto.getSubCategoryId());
            entity.setEntityEmailId(EntityDto.getEntityEmailId());
            entity.setIsActive(true);
            entity.setCreatedBy(EntityDto.getCreatedBy());
            entity.setCreatedOn(new Date());
            entity.setLastModifiedBy(EntityDto.getLastModifiedBy());
            entity.setLastModifiedOn(new Date());
            entity.setEntityPhoneNo(EntityDto.getEntityPhoneNo());
            entity.setUpdatedOn(new Date());
            entity.setEntityNameBil(EntityDto.getEntityName());
            entity.setEntityShortNameBil(EntityDto.getEntityShortName());
            entity.setBankType(EntityDto.getBankType());

            entityRepository.save(entity);
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
        return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);
    }

    //get entities-done
    public List<EntityDto> getEntities() {
        List<Entityentity> entitiesList = entityRepository.findAll();

        if (entitiesList.isEmpty()) {
            throw new GlobalException("No Users Found!");
        }

        List<EntityDto> EntityDtos = new ArrayList<>();

        for (Entityentity entity : entitiesList) {
            EntityDto entityDto = new EntityDto();

            entityDto.setEntityName(entity.getEntityName());
            entityDto.setEntityShortName(entity.getEntityShortName());
            entityDto.setEntityCode(entity.getEntityCode());
            entityDto.setComTypeId(entity.getComTypeId());
            entityDto.setCategoryId(entity.getCategoryId());
            entityDto.setSubCategoryId(entity.getSubCategoryId());
            entityDto.setEntityEmailId(entity.getEntityEmailId());
            entityDto.setCreatedBy(entity.getCreatedBy());
            entityDto.setLastModifiedBy(entity.getLastModifiedBy());
            entityDto.setEntityPhoneNo(entity.getEntityPhoneNo());
            entityDto.setBankType(entity.getBankType());

            EntityDtos.add(entityDto);
        }
        return EntityDtos;
    }

    public ResponseEntity<?> getEntity(String entityName) throws Exception {
        Optional<Entityentity> entityInDb = entityRepository.findByEntityName(entityName);
        if (entityInDb.isEmpty()) {
            throw new GlobalException("Entity Not Found!");
        }
        Entityentity entity = entityInDb.get();

        EntityDto entityDto = getEntityDto(entity);

        return new ResponseEntity<>(new ApiResponse(entityDto), HttpStatus.OK);
    }

    //method to get EntityDto from an entiity
    private static EntityDto getEntityDto(Entityentity entity) {
        EntityDto entityDto = new EntityDto();

        entityDto.setEntityName(entity.getEntityName());
        entityDto.setEntityShortName(entity.getEntityShortName());
        entityDto.setEntityCode(entity.getEntityCode());
        entityDto.setComTypeId(entity.getComTypeId());
        entityDto.setCategoryId(entity.getCategoryId());
        entityDto.setSubCategoryId(entity.getSubCategoryId());
        entityDto.setEntityEmailId(entity.getEntityEmailId());
        entityDto.setEntityPhoneNo(entity.getEntityPhoneNo());
        return entityDto;
    }

    //delete entity-done
    @Transactional
    public ResponseEntity<?> deleteEntity(String entityName) {
        Optional<Entityentity> entity = entityRepository.findByEntityName(entityName);
        if (entity.isEmpty()) {
            throw new GlobalException("Entity Not Found!");
        }
        entityRepository.delete(entity.get());
        return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);
    }

    //delete all entities-done
    @Transactional
    public ResponseEntity<?> deleteEntities() {
        try {
            entityRepository.deleteAll();
        } catch (Exception e) {
            throw new GlobalException("Unable to Delete Entities!");
        }
        return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);
    }

    //update entity
    @Transactional
    public ResponseEntity<?> updateEntity(String entityName, EntityDto entityDto) {
        Optional<Entityentity> entity = entityRepository.findByEntityName(entityName);

        if (entity.isEmpty()) {
            throw new GlobalException("Entry Not Found!");
        }

        Entityentity entityInDb = entity.get();
        entityInDb.setEntityName(entityDto.getEntityName());
        entityInDb.setEntityShortName(entityDto.getEntityShortName());
        entityInDb.setEntityCode(entityDto.getEntityCode());
        entityInDb.setIfscCode(entityDto.getEntityCode());
        entityInDb.setComTypeId(entityDto.getComTypeId());
        entityInDb.setCategoryId(entityDto.getCategoryId());
        entityInDb.setSubCategoryId(entityDto.getSubCategoryId());
        entityInDb.setEntityEmailId(entityDto.getEntityEmailId());
        entityInDb.setCreatedBy(entityDto.getCreatedBy());
        entityInDb.setLastModifiedBy(entityDto.getLastModifiedBy());
        entityInDb.setLastModifiedOn(new Date());
        entityInDb.setEntityPhoneNo(entityDto.getEntityPhoneNo());
        entityInDb.setUpdatedOn(new Date());
        entityInDb.setEntityNameBil(entityDto.getEntityName());
        entityInDb.setEntityShortNameBil(entityDto.getEntityShortName());
        entityInDb.setBankType(entityDto.getBankType());

        entityRepository.save(entityInDb);
        return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);
    }
}

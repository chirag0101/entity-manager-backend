package com.iris.entitymanager.service;

import com.iris.entitymanager.dto.EntityDto;
import com.iris.entitymanager.entity.Entityentity;
import com.iris.entitymanager.dto.ApiResponse;
import com.iris.entitymanager.exceptions.GlobalException;
import com.iris.entitymanager.repository.EntityRepository;
import jakarta.validation.Valid;
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
    public ResponseEntity<?> createNewEntity(@Valid EntityDto entityDto) {
        try {
            Entityentity entity = new Entityentity();

            entity.setEntityName(entityDto.getEntityName());
            entity.setEntityShortName(entityDto.getEntityShortName());
            entity.setEntityCode(entityDto.getEntityCode());
            entity.setIfscCode(entityDto.getEntityCode());
            entity.setCategoryId(entityDto.getCategoryId());
            entity.setSubCategoryId(entityDto.getSubCategoryId());
            entity.setEntityEmailId(entityDto.getEntityEmailId());
            entity.setIsActive(true);
            entity.setCreatedBy(entityDto.getCreatedBy());
            entity.setCreatedOn(new Date());
            entity.setLastModifiedBy(entityDto.getLastModifiedBy());
            entity.setLastModifiedOn(new Date());
            entity.setEntityPhoneNo(entityDto.getEntityPhoneNo());
            entity.setUpdatedOn(new Date());
            entity.setEntityNameBil(entityDto.getEntityName());
            entity.setEntityShortNameBil(entityDto.getEntityShortName());
            entity.setBankType(entityDto.getBankType());

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

        List<EntityDto> entityDtos = new ArrayList<>();

        for (Entityentity entity : entitiesList) {
            EntityDto entityDto = new EntityDto();

            entityDto.setEntityName(entity.getEntityName());
            entityDto.setEntityShortName(entity.getEntityShortName());
            entityDto.setEntityCode(entity.getEntityCode());
            entityDto.setCategoryId(entity.getCategoryId());
            entityDto.setSubCategoryId(entity.getSubCategoryId());
            entityDto.setEntityEmailId(entity.getEntityEmailId());
            entityDto.setCreatedBy(entity.getCreatedBy());
            entityDto.setLastModifiedBy(entity.getLastModifiedBy());
            entityDto.setEntityPhoneNo(entity.getEntityPhoneNo());
            entityDto.setBankType(entity.getBankType());

            entityDtos.add(entityDto);
        }
        return entityDtos;
    }

    public ResponseEntity<?> getEntity(int entityId) throws GlobalException {
        Optional<Entityentity> entityInDb = entityRepository.findById(entityId);
        if (entityInDb.isEmpty()) {
            throw new GlobalException("E404");
        }
        Entityentity entity = entityInDb.get();

        EntityDto entityDto = getEntityDto(entity);

        return new ResponseEntity<>(new ApiResponse(entityDto), HttpStatus.OK);
    }

    //method to get EntityDto from an entity
    private static EntityDto getEntityDto(Entityentity entity) {
        EntityDto entityDto = new EntityDto();

        entityDto.setEntityName(entity.getEntityName());
        entityDto.setEntityShortName(entity.getEntityShortName());
        entityDto.setEntityCode(entity.getEntityCode());
        entityDto.setCategoryId(entity.getCategoryId());
        entityDto.setSubCategoryId(entity.getSubCategoryId());
        entityDto.setEntityEmailId(entity.getEntityEmailId());
        entityDto.setCreatedBy(entity.getCreatedBy());
        entityDto.setLastModifiedBy(entity.getLastModifiedBy());
        entityDto.setEntityPhoneNo(entity.getEntityPhoneNo());
        entityDto.setBankType(entity.getBankType());
        return entityDto;
    }

    //delete entity-done
    @Transactional
    public ResponseEntity<?> deleteEntity(int entityId) {
        Optional<Entityentity> entity = entityRepository.findById(entityId);
        if (entity.isEmpty()) {
            throw new GlobalException("E404");
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
    public ResponseEntity<?> updateEntity(int entityId, @Valid EntityDto entityDto) throws GlobalException {
        Optional<Entityentity> entity = entityRepository.findById(entityId);

        if (entity.isEmpty()) {
            throw new GlobalException("E404");
        }

        Entityentity entityInDb = entity.get();
        entityInDb.setEntityName(entityDto.getEntityName());
        entityInDb.setEntityShortName(entityDto.getEntityShortName());
        entityInDb.setEntityCode(entityDto.getEntityCode());
        entityInDb.setIfscCode(entityDto.getEntityCode());
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

package com.iris.entitymanager.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iris.entitymanager.controller.EntityController;
import com.iris.entitymanager.dto.EntityDto;
import com.iris.entitymanager.entity.EntityLabelModentity;
import com.iris.entitymanager.entity.EntityLabelentity;
import com.iris.entitymanager.entity.EntityModentity;
import com.iris.entitymanager.entity.Entityentity;
import com.iris.entitymanager.dto.ApiResponse;
import com.iris.entitymanager.exceptions.GlobalException;
import com.iris.entitymanager.repository.*;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class EntityService {

    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private ErrorRepository errorRepository;

    @Autowired
    private EntityModRepository entityModRepository;

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private LabelModRepository labelModRepository;

    Logger logger = LogManager.getLogger(EntityController.class);

    //create new entity entry - done
    @Transactional
    public ResponseEntity<?> createNewEntity(@Valid EntityDto entityDto) {
        try {
            Optional<Entityentity> entityIndB = entityRepository.findByEntityName(entityDto.getEntityName());

            if (entityIndB.isPresent()) {
                throw new GlobalException("E302");
            }

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
            entity.setLastModifiedBy(null);
            entity.setLastModifiedOn(null);
            entity.setEntityPhoneNo(entityDto.getEntityPhoneNo());
            entity.setUpdatedOn(new Date());
            entity.setEntityNameBil(entityDto.getEntityName());
            entity.setEntityShortNameBil(entityDto.getEntityShortName());
            entity.setBankType(entityDto.getBankType());
            entity.setLabel(entityDto.getLabel());

            //setting up label
            EntityLabelentity entityLabelentity = new EntityLabelentity();
            entityLabelentity.setEntityIdFk(entity);
            entityLabelentity.setLabel(entity.getLabel());
            entityLabelentity.setLastModifiedOn(null);
            entityLabelentity.setLastModifiedBy(null);
            labelRepository.save(entityLabelentity);

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
            throw new GlobalException("E005");
        }

        List<EntityDto> entityDtos = new ArrayList<>();

        for (Entityentity entity : entitiesList) {
            if (entity.getIsActive()) {
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
                entityDto.setLabel(entity.getLabel());

                entityDtos.add(entityDto);
            }
        }
        return entityDtos;
    }

    public ResponseEntity<?> getEntity(int entityId) throws GlobalException {
        Optional<Entityentity> entityInDb = entityRepository.findById(entityId);

        if (entityInDb.isEmpty()) {
            throw new GlobalException("E404");
        }

        Entityentity entity = entityInDb.get();
        if (entity.getIsActive()) {
            EntityDto entityDto = getEntityDto(entity);
            List<EntityDto> entityDtoList = new ArrayList<>();
            entityDtoList.add(entityDto);
            return new ResponseEntity<>(new ApiResponse(entityDtoList), HttpStatus.OK);
        }

        throw new GlobalException("E404");
    }

    public ResponseEntity<?> getEntityMods(int entityId) throws GlobalException {
//      query does this for us, saving looping time

        List<EntityModentity> entityModentities = entityModRepository.findAll(entityId);

        if (entityModentities.isEmpty()) {
            throw new GlobalException("E404");
        }

        return new ResponseEntity<>(new ApiResponse<>(entityModentities), HttpStatus.OK);
    }

    //delete entity-done
    @Transactional
    public ResponseEntity<?> deleteEntity(int entityId) {
        Optional<Entityentity> entity = entityRepository.findById(entityId);
        if (entity.isEmpty()) {
            throw new GlobalException("E404");
        }

        Entityentity entityInDb = entity.get();

        if (entityInDb.getIsActive()) {
            entityInDb.setIsActive(false);
        } else {
            throw new GlobalException("E004");
        }

        return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);
    }

    //delete all entities-done
    @Transactional
    public ResponseEntity<?> deleteEntities() {
        try {
//            entityRepository.deleteAll();
            List<Entityentity> entities = entityRepository.findAll();

            for (Entityentity entity : entities) {
                entity.setIsActive(false);
            }

        } catch (Exception e) {
            throw new GlobalException("E006");
        }
        return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);
    }

    //update entity

    @Transactional
    public ResponseEntity<?> updateEntity(Integer entityId, EntityDto entityDto) throws GlobalException {
        Optional<Entityentity> entityOptional = entityRepository.findById(entityId);

        if (entityOptional.isEmpty()) {
            throw new GlobalException("E404");
        }

        Entityentity entityInDb = entityOptional.get();

        if (!(entityInDb.getIsActive())) {
            throw new GlobalException("E404");
        }

        //checking if bank name has changed
        if (!(entityInDb.getEntityName().equals(entityDto.getEntityName()))
                || !(entityInDb.getEntityShortName().equals(entityDto.getEntityShortName()))
                || !(entityInDb.getEntityCode().equals(entityDto.getEntityCode()))
                || !(entityInDb.getCategoryId() == entityDto.getCategoryId())
                || !(entityInDb.getSubCategoryId() == (entityDto.getSubCategoryId()))
                || !(entityInDb.getEntityEmailId().equals(entityDto.getEntityEmailId()))
                || !(entityInDb.getCreatedBy() == (entityDto.getCreatedBy()))
                || !(entityInDb.getLastModifiedBy().equals(entityDto.getLastModifiedBy()))
                || !(entityInDb.getEntityPhoneNo().equals(entityDto.getEntityPhoneNo()))
                || !(entityInDb.getBankType() == (entityDto.getBankType()))
                || !(entityInDb.getLabel().equals(entityDto.getLabel()))
        ) {

            String previousDataJson = preparePreviousDataJson(entityInDb);

            // Saving the previous data in the EntityMod table
            EntityModentity entityModentity = new EntityModentity();
            entityModentity.setEntityIdFk(entityInDb);

            if(!(entityInDb.getLabel().equals(entityDto.getLabel()))){

                Optional<EntityLabelentity> entityLabelInDb=labelRepository.findById(entityId);
                if(entityLabelInDb.isEmpty()){
                    throw new GlobalException("E404");
                }

                EntityLabelentity entityLabelentity=entityLabelInDb.get();

                String prevLabelDataJson=preparePreviousDataJson(entityLabelentity);

                EntityLabelModentity entityLabelModentity=new EntityLabelModentity();
                entityLabelModentity.setEntityLabelIdFk(entityLabelentity);
                entityLabelModentity.setLastModifiedOn(new Date());
                entityLabelModentity.setLastModifiedByFk(entityDto.getLastModifiedBy());
                entityLabelModentity.setPrevDataJson(prevLabelDataJson);
                labelModRepository.save(entityLabelModentity);

                entityLabelentity.setLabel(entityDto.getLabel());
                entityLabelentity.setLastModifiedBy(entityDto.getLastModifiedBy());
                entityLabelentity.setLastModifiedOn(entityLabelModentity.getLastModifiedOn());
                labelRepository.save(entityLabelentity);

            }

            //updating new updates in Entity Table
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
            entityInDb.setLabel(entityDto.getLabel());

            entityModentity.setLastModifiedByFk(entityInDb.getLastModifiedBy());
            entityModentity.setLastModifiedOn(entityInDb.getLastModifiedOn());
            entityModentity.setPrevDataJson(previousDataJson);
            entityModRepository.save(entityModentity);

            entityRepository.save(entityInDb);
        }
        return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);
    }

    //method for converting object data json
    private String preparePreviousDataJson(Object entityInDb) {

        // Convert the map to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(entityInDb);
        } catch (JsonProcessingException e) {
            logger.error(e);
            return "{}";
        }
    }

    //method to get EntityDto from an entity
    private EntityDto getEntityDto(Entityentity entity) {
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
}

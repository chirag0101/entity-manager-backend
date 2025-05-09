package com.iris.entitymanager.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iris.entitymanager.controller.EntityController;
import com.iris.entitymanager.dto.ApiResponse;
import com.iris.entitymanager.dto.EntityDto;
import com.iris.entitymanager.dto.EntityModDto;
import com.iris.entitymanager.entity.*;
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
import org.springframework.web.client.RestTemplate;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EntityService {

    @Autowired
    private EntityRepository entityRepository;

//    @Autowired
//    private ErrorRepository errorRepository;

    @Autowired
    private EntityModRepository entityModRepository;

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private LabelModRepository labelModRepository;

    @Autowired
    private LangRepository langRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiRepository apiRepository;

    Logger logger = LogManager.getLogger(EntityController.class);

    //create new entity entry - done
    @Transactional
    public ResponseEntity<?> createNewEntity(@Valid EntityDto entityDto) {
        try {
            // Check if the entity with the same name already exists
            Optional<Entityentity> entityInDb = entityRepository.findByEntityName(entityDto.getEntityName());
            if (entityInDb.isPresent()) {
                throw new GlobalException("E302"); // Entity already exists
            }

            // Create a new entity from the DTO
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

            entityRepository.save(entity);

            //checking if the language isActive
            Optional<Lang> langEntity = langRepository.findByLanguageName(entityDto.getLabel());
            if (!langEntity.isPresent() || !langEntity.get().getIsActive()) {
                throw new GlobalException("Language is inactive!"); // If language is inactive or not found
            }

            //setting if both are active
            List<Lang> activeLangEntities = langRepository.findAllisActive();
            if (activeLangEntities.stream().allMatch(lang -> lang.getIsActive())) {
                for (Lang lang : activeLangEntities) {
                    EntityLabel entityLabel = new EntityLabel();
                    entityLabel.setEntityIdFk(entity);
                    entityLabel.setLabel(entity.getLabel());
                    entityLabel.setLastModifiedOn(null);
                    entityLabel.setLastModifiedBy(null);
                    entityLabel.setLangIdFk(lang.getLangId());
                    labelRepository.saveAndFlush(entityLabel);
                }
            } else {
                // If only the given label is active, save it
                EntityLabel entityLabel = new EntityLabel();
                entityLabel.setEntityIdFk(entity);
                entityLabel.setLabel(entity.getLabel());
                entityLabel.setLastModifiedOn(null);
                entityLabel.setLastModifiedBy(null);
                entityLabel.setLangIdFk(langEntity.get().getLangId());
                labelRepository.save(entityLabel);
            }

            entityRepository.save(entity);

        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
        return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);
    }

    //create new languages
    public ResponseEntity<?> createNewLang(Lang langEntity) {
        List<Lang> existingLang = langRepository.findAll();

        for (Lang l : existingLang) {
            if (l.getLanguage().equals(langEntity.getLanguage())) {
                throw new GlobalException("Language Already Exists!");
            }
        }

        langRepository.save(langEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //get entities-done
    public List<EntityDto> getEntities() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
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

    public EntityDto getEntity(int entityId) throws GlobalException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        Optional<Entityentity> entityInDb = entityRepository.findById(entityId);

        if (entityInDb.isEmpty()) {
            throw new GlobalException("E404");
        }

        Entityentity entity = entityInDb.get();
        if (entity.getIsActive()) {
            EntityDto entityDto = getEntityDto(entity);
            return entityDto;
//            List<EntityDto> entityDtoList = new ArrayList<>();
//            entityDtoList.add(entityDto);
//            return new ResponseEntity<>(new ApiResponse(entityDtoList), HttpStatus.OK);
        }

        throw new GlobalException("E404");
    }

    public List<EntityMod> getEntityMods(int entityId) throws GlobalException {
//      query does this for us, saving looping time

        List<EntityMod> entityModentities = entityModRepository.findAll(entityId);

        if (entityModentities.isEmpty()) {
            throw new GlobalException("E404");
        }

        return entityModentities;
        // return new ResponseEntity<>(new ApiResponse<>(entityModentities), HttpStatus.OK);
    }

    //get entry with mods
    public ResponseEntity<?> getEntityWithMods(Integer entityId) {
        try {
            EntityModDto entityModDto = new EntityModDto();

            ApiNameWithURL apiNameWithURLForMod = apiRepository.findByApiName("viewEntity");

            ApiNameWithURL apiEntityForMod = apiRepository.findByApiName("viewModifications");

            ResponseEntity<EntityDto> entityDtoResponse = restTemplate.getForEntity(
                    apiNameWithURLForMod.getApiUrl() + entityId, EntityDto.class);

            entityModDto.setEntityDto(entityDtoResponse.getBody());

            if ((entityDtoResponse.getBody().getLastModifiedBy() != null)) {
                List entityModEntities = restTemplate.getForObject(
                        apiEntityForMod.getApiUrl() + entityId,
                        List.class
                );

                entityModDto.setEntityModentities(entityModEntities);
            } else {
                entityModDto.setEntityModentities(List.of());
            }

            return new ResponseEntity<>(new ApiResponse<>(entityModDto), HttpStatus.OK);

        } catch (GlobalException e) {
            throw new GlobalException("E404");
        }
    }

    //get entries based on Lang-id
    public ResponseEntity<?> getLabelEntries(Integer langId) {
        return new ResponseEntity<>(labelRepository.findBylangIdFk(langId), HttpStatus.OK);
    }

    //get mod label entries
    public ResponseEntity<?> getLabelMod(Integer labelId) {
        return new ResponseEntity<>(labelModRepository.findByEntityLabelIdFk(labelId), HttpStatus.OK);
    }

    //get all active langs
    public ResponseEntity<?> getAllActiveLang() {
        return new ResponseEntity<>(langRepository.findAllisActive(), HttpStatus.OK);
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

    //update language
    public ResponseEntity<?> modifyLang(Integer langId, Lang langEntity) {
        Optional<Lang> existingLang = langRepository.findById(langId);

        if (existingLang.isEmpty()) {
            throw new GlobalException("E404");
        }

        List<Lang> existingLangs = langRepository.findAll();

        for (Lang l : existingLangs) {
            if (l.getLanguage().equals(langEntity.getLanguage())) {
                throw new GlobalException("Language Already Exists!");
            }
        }

        Lang newEntity = existingLang.get();
        newEntity.setLanguage(langEntity.getLanguage());
        langRepository.save(newEntity);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //update entity

    @Transactional
    public ResponseEntity<?> updateEntity(Integer entityId, EntityDto entityDto) throws GlobalException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
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
            EntityMod entityMod = new EntityMod();
            entityMod.setEntityIdFk(entityInDb);

            //if label is different than adding mod in label_mod table
            if (!(entityInDb.getLabel().equals(entityDto.getLabel()))) {

                Optional<EntityLabel> entityLabelInDb = labelRepository.findById(entityId);
                if (entityLabelInDb.isEmpty()) {
                    throw new GlobalException("E404");
                }

                EntityLabel entityLabel = entityLabelInDb.get();

                String prevLabelDataJson = preparePreviousDataJson(entityLabel);

                EntityLabelMod entityLabelMod = new EntityLabelMod();
                entityLabelMod.setEntityLabelIdFk(entityLabel);
                entityLabelMod.setLastModifiedOn(new Date());
                entityLabelMod.setLastModifiedByFk(entityDto.getLastModifiedBy());
                entityLabelMod.setPrevDataJson(prevLabelDataJson);
                labelModRepository.save(entityLabelMod);

                entityLabel.setLabel(entityDto.getLabel());
                entityLabel.setLastModifiedBy(entityDto.getLastModifiedBy());
                entityLabel.setLastModifiedOn(entityLabelMod.getLastModifiedOn());

                Optional<Lang> langEntity = langRepository.findByLanguageName(entityDto.getLabel());

                //checking if given label is active or not
                if (!(langEntity.get().getIsActive())) {
                    throw new GlobalException("Language is inactive!");
                }

                entityLabel.setLangIdFk(langRepository.findByLanguage(entityDto.getLabel()));
                labelRepository.save(entityLabel);
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

            entityMod.setLastModifiedByFk(entityInDb.getLastModifiedBy());
            entityMod.setLastModifiedOn(entityInDb.getLastModifiedOn());
            entityMod.setPrevDataJson(previousDataJson);
            entityModRepository.save(entityMod);

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
    private EntityDto getEntityDto(Entityentity entity) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        EntityDto entityDto = new EntityDto();

        entityDto.setEntityName(entity.getEntityName());
        entityDto.setEntityShortName(entity.getEntityShortName());
        entityDto.setEntityCode(entity.getEntityCode());
        entityDto.setCategoryId(entity.getCategoryId());
        entityDto.setSubCategoryId(entity.getSubCategoryId());
        entityDto.setEntityEmailId(entity.getEntityEmailId());
        entityDto.setLastModifiedBy(entity.getLastModifiedBy());
        entityDto.setCreatedBy(entity.getCreatedBy());
        entityDto.setEntityPhoneNo(entity.getEntityPhoneNo());
        entityDto.setBankType(entity.getBankType());
        entityDto.setLabel(entity.getLabel());
        return entityDto;
    }

}
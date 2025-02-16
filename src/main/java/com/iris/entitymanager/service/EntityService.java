    package com.iris.entitymanager.service;

    import com.iris.entitymanager.dto.EntityRequestDto;
    import com.iris.entitymanager.entity.Entityentity;
    import com.iris.entitymanager.entity.ErrorResponseEntity;
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

        //create new entity entry
        @Transactional
        public ResponseEntity<?> createNewEntity(EntityRequestDto entityRequestDto){
            Entityentity entity=convertToEntity(entityRequestDto);
            entityRepository.save(entity);
            return new ResponseEntity<>(new ErrorResponseEntity(), HttpStatus.OK);
        }

        //get entities
        public ResponseEntity<?> getEntities(){
            List<Entityentity> entitiesList=entityRepository.findAll();
            List<EntityRequestDto> entityRequestDtos=new ArrayList<>();

            for(Entityentity entity:entitiesList){
                entityRequestDtos.add(convertToDto(entity));
            }

            return new ResponseEntity<>(entityRequestDtos,HttpStatus.OK);
        }

        public ResponseEntity<?> getEntity(String entityName) throws Exception{
            Optional<Entityentity> entityInDb=entityRepository.findByEntityName(entityName);
            if(entityInDb.isEmpty()){
                throw new GlobalException("Entity Not Found!");
            }
            Entityentity entity=entityInDb.get();
            return new ResponseEntity<>(new ErrorResponseEntity(convertToDto(entity)),HttpStatus.FOUND);
        }

        //delete entity
        @Transactional
        public ResponseEntity<?> deleteEntity(String entityName){
            Optional<Entityentity> entity=entityRepository.findByEntityName(entityName);
            if(entity.isEmpty()){
                throw new GlobalException("Entity Not Found!");
            }
            entityRepository.delete(entity.get());
            return new ResponseEntity<>(new ErrorResponseEntity(),HttpStatus.OK);
        }

        //delete all entities
        @Transactional
        public ResponseEntity<?> deleteEntities(){
            entityRepository.deleteAll();
            return new ResponseEntity<>(new ErrorResponseEntity(),HttpStatus.OK);
        }

        //update entity
        @Transactional
        public ResponseEntity<?> updateEntity(String entityName,EntityRequestDto entityDto){
            Optional<Entityentity> entity=entityRepository.findByEntityName(entityName);

            if(entity.isEmpty()){
                throw new GlobalException("Entry Not Found!");
            }

            Entityentity entityInDb=entity.get();
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
            return new ResponseEntity<>(new ErrorResponseEntity(),HttpStatus.OK);
        }


        //converting to dto
        public EntityRequestDto convertToDto(Entityentity entity){
            return new EntityRequestDto(entity.getEntityName(),entity.getEntityShortName(),entity.getEntityCode(),entity.getComTypeId(),entity.getCategoryId(),entity.getSubCategoryId(),entity.getEntityEmailId(),entity.getCreatedBy(),entity.getLastModifiedBy(),entity.getEntityPhoneNo(),entity.getBankType());
        }

        public Entityentity convertToEntity(EntityRequestDto entityDto){
            Entityentity entity = new Entityentity();

            // Map the fields from the DTO to the entity
            entity.setEntityName(entityDto.getEntityName());
            entity.setEntityShortName(entityDto.getEntityShortName());
            entity.setEntityCode(entityDto.getEntityCode());
            entity.setIfscCode(entityDto.getEntityCode());
            entity.setComTypeId(entityDto.getComTypeId());
            entity.setCategoryId(entityDto.getCategoryId());
            entity.setSubCategoryId(entityDto.getSubCategoryId());
            entity.setEntityEmailId(entityDto.getEntityEmailId());
            entity.setCreatedBy(entityDto.getCreatedBy());
            entity.setLastModifiedBy(entityDto.getLastModifiedBy());
            entity.setEntityPhoneNo(entityDto.getEntityPhoneNo());
            entity.setEntityNameBil(entityDto.getEntityName());
            entity.setEntityShortNameBil(entityDto.getEntityShortName());
            entity.setBankType(entityDto.getBankType());

            return entity;
        }
    }

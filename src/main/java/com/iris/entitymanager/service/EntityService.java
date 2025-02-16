    package com.iris.entitymanager.service;

    import com.iris.entitymanager.dto.EntityRequestDto;
    import com.iris.entitymanager.entity.Entityentity;
    import com.iris.entitymanager.entity.ErrorResponseEntity;
    import com.iris.entitymanager.exceptions.InvalidEntityNameException;
    import com.iris.entitymanager.repository.EntityRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class EntityService {

        @Autowired
        private EntityRepository entityRepository;

        //create new entity entry
        public ResponseEntity<?> createNewEntity(Entityentity entityentity){
            entityRepository.save(entityentity);
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
            Optional<Entityentity> entity=entityRepository.findByEntityName(entityName);
            if(entity.isEmpty()){
                throw new InvalidEntityNameException("Entity Not Found!");
            }
            return new ResponseEntity<>(entity.get(),HttpStatus.FOUND);
        }

        //delete entity
        public ResponseEntity<?> deleteEntity(String entityName){
            Optional<Entityentity> entity=entityRepository.findByEntityName(entityName);
            if(entity.isEmpty()){
                throw new InvalidEntityNameException("Entity Not Found!");
            }
            entityRepository.delete(entity.get());
            return new ResponseEntity<>(new ErrorResponseEntity(),HttpStatus.OK);
        }

        //delete all entities
        public ResponseEntity<?> deleteEntities(){
            entityRepository.deleteAll();
            return new ResponseEntity<>(new ErrorResponseEntity(),HttpStatus.OK);
        }

        //update entity
        public ResponseEntity<?> updateEntity(String entityName,EntityRequestDto entityDto){
            Optional<Entityentity> entity=entityRepository.findByEntityName(entityName);

            if(entity.isEmpty()){
                throw new InvalidEntityNameException("Entry Not Found!");
            }

            Entityentity entityInDb=entity.get();
            entityInDb.setEntityName(entityDto.getEntityName());
            entityInDb.setEntityShortName(entityDto.getEntityShortName());
            entityInDb.setEntityCode(entityDto.getEntityCode());
            entityInDb.setIfscCode(entityDto.getIfscCode());
            entityInDb.setComTypeId(entityDto.getComTypeId());
            entityInDb.setCategoryId(entityDto.getCategoryId());
            entityInDb.setSubCategoryId(entityDto.getSubCategoryId());
            entityInDb.setEntityEmailId(entityDto.getEntityEmailId());
            entityInDb.setCreatedBy(entityDto.getCreatedBy());
            entityInDb.setLastModifiedBy(entityDto.getLastModifiedBy());
            entityInDb.setEntityPhoneNo(entityDto.getEntityPhoneNo());
            entityInDb.setEntityNameBil(entityDto.getEntityNameBil());
            entityInDb.setBankType(entityDto.getBankType());

            entityRepository.save(entityInDb);
            return new ResponseEntity<>(new ErrorResponseEntity(),HttpStatus.OK);
        }


        //converting to dto
        public EntityRequestDto convertToDto(Entityentity entity){
            return new EntityRequestDto(entity.getEntityName(),entity.getEntityShortName(),entity.getEntityCode(),entity.getIfscCode(),entity.getComTypeId(),entity.getCategoryId(),entity.getSubCategoryId(),entity.getEntityEmailId(),entity.getCreatedBy(),entity.getLastModifiedBy(),entity.getEntityPhoneNo(),entity.getEntityNameBil(),entity.getEntityShortName(),entity.getBankType());
        }
    //    public EntityRequestDto convertToEntity(EntityRequestDto entity){
    //        Optional
    //        return new Entityentity();
    //    }
    }

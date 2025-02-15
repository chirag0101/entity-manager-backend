package com.iris.entitymanager.controller;

import com.iris.entitymanager.entity.Entityentity;
import com.iris.entitymanager.service.EntityService;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//checking validations
@RestController
@RequestMapping("/entitymanager")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @PostMapping("/newentity")
    public ResponseEntity<?> createEntity(@Valid @RequestBody Entityentity entityentity){
        return entityService.createNewEntity(entityentity);
    }

    @GetMapping("/entities")
    public ResponseEntity<?> viewEntities(){
        return entityService.getEntities();
    }

    @GetMapping("/entity/{entityName}")
    public ResponseEntity<?> viewEntity(@PathVariable String entityName){
        try{
            return entityService.getEntity(entityName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/entity/{entityName}")
    public ResponseEntity<?> deleteEntity(@PathVariable String entityName){
        return entityService.deleteEntity(entityName);
    }

    @DeleteMapping("/entities")
    public ResponseEntity<?> deleteEntities(){
        return entityService.deleteEntities();
    }

}

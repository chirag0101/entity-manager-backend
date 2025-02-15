package com.iris.entitymanager.controller;

import com.iris.entitymanager.entity.Entityentity;
import com.iris.entitymanager.service.EntityService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entitymanager")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @PostMapping("/newentity")
    public ResponseEntity<?> createEntity(@RequestBody Entityentity entityentity){
        return entityService.createNewEntity(entityentity);
    }

    @GetMapping("/entities")
    public ResponseEntity<?> viewEntities(){
        return entityService.getEntries();
    }

}

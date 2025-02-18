package com.iris.entitymanager.controller;

import com.iris.entitymanager.dto.EntityDto;
import com.iris.entitymanager.service.EntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//done: validations checking!

@RestController
@RequestMapping("/entityService")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @PostMapping("/addEntity")
    public ResponseEntity<?> createEntity(@Valid @RequestBody EntityDto EntityDto) {
        return entityService.createNewEntity(EntityDto);
    }

    @GetMapping("/viewEntities")
    public ResponseEntity<?> viewEntities() {
        return new ResponseEntity<>(entityService.getEntities(), HttpStatus.OK);
    }

    @GetMapping("/viewEntity/{entityId}")
    public ResponseEntity<?> viewEntity(@PathVariable int entityId) {
        try {
            return entityService.getEntity(entityId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/deleteEntity/{entityId}")
    public ResponseEntity<?> deleteEntity(@PathVariable int entityId) {
        return entityService.deleteEntity(entityId);
    }

    @DeleteMapping("/deleteEntities")
    public ResponseEntity<?> deleteEntities() {
        return entityService.deleteEntities();
    }

    @PutMapping("/modifyEntity/{entityId}")
    public ResponseEntity<?> updateEntity(@Valid @RequestBody EntityDto entityDto, @PathVariable int entityId) {
        try {
            return entityService.updateEntity(entityId, entityDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

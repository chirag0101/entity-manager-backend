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

    @GetMapping("/viewEntries")
    public ResponseEntity<?> viewEntities() {
        return new ResponseEntity<>(entityService.getEntities(), HttpStatus.OK);
    }

    @GetMapping("/viewEntry/{entityName}")
    public ResponseEntity<?> viewEntity(@PathVariable String entityName) {
        try {
            return entityService.getEntity(entityName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/deleteEntry/{entityName}")
    public ResponseEntity<?> deleteEntity(@PathVariable String entityName) {
        return entityService.deleteEntity(entityName);
    }

    @DeleteMapping("/deleteEntries")
    public ResponseEntity<?> deleteEntities() {
        return entityService.deleteEntities();
    }

    @PutMapping("/modifyEntry/{entityName}")
    public ResponseEntity<?> updateEntity(@Valid @RequestBody EntityDto entityDto, @PathVariable String entityName) {
        try {
            return entityService.updateEntity(entityName, entityDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

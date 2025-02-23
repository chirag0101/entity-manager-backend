package com.iris.entitymanager.controller;

import com.iris.entitymanager.dto.EntityDto;
import com.iris.entitymanager.entity.LangEntity;
import com.iris.entitymanager.exceptions.GlobalException;
import com.iris.entitymanager.service.EntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//done: validations checking!

@RestController
@RequestMapping("/entityService")
public class EntityController {

    @Autowired
    private EntityService entityService;

    private static final Logger logger = LogManager.getLogger(EntityController.class);

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

    @GetMapping("/viewEntity/viewModifications/{entityId}")
    public ResponseEntity<?> viewEntityModifications(@PathVariable int entityId){
        try{
            return entityService.getEntityMods(entityId);
        }catch (Exception e){
            throw new GlobalException(e.getMessage());
        }
    }

    @GetMapping("/getLangEntries/{langId}")
    public ResponseEntity<?> getLangEntries(@PathVariable Integer langId){
        return entityService.getLabelEntries(langId);
    }

    @GetMapping("/getLabelMods/{labelId}")
    public ResponseEntity<?> getLabelMods(@PathVariable Integer labelId){
        return entityService.getLabelMod(labelId);
    }

    @GetMapping("/getActiveLang")
    public ResponseEntity<?> getActiveLang(){
        return entityService.getAllActiveLang();
    }

    @DeleteMapping("/deleteEntity/{entityId}")
    public ResponseEntity<?> deleteEntity(@PathVariable int entityId) {
        return entityService.deleteEntity(entityId);
    }

    @DeleteMapping("/deleteEntities")
    public ResponseEntity<?> deleteEntities() {
        return entityService.deleteEntities();
    }

    @PostMapping("/modifyEntity/{entityId}")
    public ResponseEntity<?> updateEntity(@Valid @RequestBody EntityDto entityDto, @PathVariable("entityId") Integer entityId) {
        try {
            return entityService.updateEntity(entityId, entityDto);
        } catch (RuntimeException e) {
            throw new GlobalException(e.getMessage());
        }
    }

    @PostMapping("/addNewLang")
    public ResponseEntity<?> newLang(@RequestBody LangEntity langEntity){
        return entityService.createNewLang(langEntity);
    }

    @PostMapping("/updateLang/{langId}")
    public ResponseEntity<?> updateLang(@PathVariable Integer langId,@RequestBody LangEntity langEntity){
        return entityService.modifyLang(langId,langEntity);
    }

}

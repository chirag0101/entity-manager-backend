package com.iris.entitymanager.controller;

import com.iris.entitymanager.dto.EntityDto;
import com.iris.entitymanager.entity.EntityMod;
import com.iris.entitymanager.entity.Lang;
import com.iris.entitymanager.exceptions.GlobalException;
import com.iris.entitymanager.service.EntityService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

//done: validations checking!

@RestController
@RequestMapping("/entityService")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LogManager.getLogger(EntityController.class);

    @PostMapping("/addEntity")
    public ResponseEntity<?> createEntity(@Valid @RequestBody EntityDto EntityDto) {
        return entityService.createNewEntity(EntityDto);
    }

    @GetMapping("/viewEntities")
    public ResponseEntity<?> viewEntities() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        return new ResponseEntity<>(entityService.getEntities(), HttpStatus.OK);
    }

    @GetMapping("/viewEntity/{entityId}")
    public EntityDto viewEntity(@PathVariable int entityId) {
        try {
            return entityService.getEntity(entityId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/viewEntity/viewModifications/{entityId}")
    public List<EntityMod> viewEntityModifications(@PathVariable int entityId) {
        try {
            return entityService.getEntityMods(entityId);
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }


    @GetMapping("/viewEntityWithMod/{entityId}")
    public ResponseEntity<?> viewEntityWithMod(@PathVariable Integer entityId) {
        return entityService.getEntityWithMods(entityId);
    }

    @GetMapping("/getLangEntries/{langId}")
    public ResponseEntity<?> getLangEntries(@PathVariable Integer langId) {
        return entityService.getLabelEntries(langId);
    }

    @GetMapping("/getLabelMods/{labelId}")
    public ResponseEntity<?> getLabelMods(@PathVariable Integer labelId) {
        return entityService.getLabelMod(labelId);
    }

    @GetMapping("/getActiveLang")
    public ResponseEntity<?> getActiveLang() {
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
    public ResponseEntity<?> updateEntity(@Valid @RequestBody EntityDto entityDto, @PathVariable("entityId") Integer entityId) throws GlobalException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        return entityService.updateEntity(entityId, entityDto);
    }

    @PostMapping("/addNewLang")
    public ResponseEntity<?> newLang(@RequestBody Lang lang) {
        return entityService.createNewLang(lang);
    }

    @PostMapping("/updateLang/{langId}")
    public ResponseEntity<?> updateLang(@PathVariable Integer langId, @RequestBody Lang lang) {
        return entityService.modifyLang(langId, lang);
    }

}

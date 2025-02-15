package com.iris.entitymanager.service;

import com.iris.entitymanager.entity.Entityentity;
import com.iris.entitymanager.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EntityService {

    @Autowired
    private EntityRepository entityRepository;

    //create new entity entry
    public ResponseEntity<?> createNewEntity(Entityentity entityentity){
        System.out.println("Received entityShortName: " + entityentity.getEntityShortName());
        entityRepository.save(entityentity);
        return new ResponseEntity<>(entityentity, HttpStatus.OK);
    }

    //get entities
    public ResponseEntity<?> getEntries(){
        return new ResponseEntity<>(entityRepository.findAll(),HttpStatus.OK);
    }
}

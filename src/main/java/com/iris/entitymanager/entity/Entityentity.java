package com.iris.entitymanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
public class Entityentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String entity_name;
}

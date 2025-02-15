package com.iris.entitymanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

@Entity
@Table(name = "TBL_ENTITY")
public class Entityentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "ID")
    private String entityName;

    @Column(name = "ID")
    private String entityShortname;

    @Column(name = "ID")
    private String entityCode;

    @Column(name = "ID")
    private String ifscCode;

    @Column(name = "ID")
    private String comTypeId;

    @Column(name = "ID")
    private String categoryId;

    @Column(name = "ID")
    private String subCategoryId;

    @Column(name = "ID")
    private String entityEmailId;

    @Column(name = "ID")
    private boolean isActive;

    @Column(name = "ID")
    private int createdBy;

    @Column(name = "ID")
    private Date createdOn;

    @Column(name = "ID")
    private int lastModifiedBy;

    @Column(name = "ID")
    private Date lastModifiedOn;

    @Column(name = "ID")
    private String entityPhoneNo;

    @Column(name = "ID")
    private Date updatedOn;

    @Column(name = "ID")
    private String entityNameBil;

    @Column(name = "")
    private String entityShortName;

    @Column(name = "BANK_TYPE")
    private int bankType;

}

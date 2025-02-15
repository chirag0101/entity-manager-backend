package com.iris.entitymanager.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class EntityRequestDto {
    @Pattern(regexp = "^[a-zA-Z1-9.&]{200}$")
    @Size(min=1, max=200)
    private String entityName;

    private String entityShortname;
    private String entityCode;
    private String ifscCode;
    private String comTypeId;
    private String categoryId;
    private String subCategoryId;
    private String entityEmailId;
    private boolean isActive;
    private int createdBy;
    private Date createdOn;
    private int lastModifiedBy;
    private Date lastModifiedOn;
    private String entityPhoneNo;
    private Date updatedOn;
    private String entityNameBil;
    private String entityShortName;
    private int bankType;
}

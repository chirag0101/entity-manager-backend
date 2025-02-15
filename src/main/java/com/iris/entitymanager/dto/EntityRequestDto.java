package com.iris.entitymanager.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class EntityRequestDto {
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z1-9.&]{200}$")
    @Size(min=1, max=200)
    private String entityName;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z1-9.&]{100}$")
    @Size(min=1, max=100)
    private String entityShortname;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9.&]$")
    @Size(min=4, max=24)
    private String entityCode;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9.&]$")
    @Size(min=4, max=24)
    private String ifscCode;

    //private String comTypeId;

    private int categoryId;
    private int subCategoryId;

    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$")
    private String entityEmailId;

    private boolean isActive=true;

    private int createdBy;

    private Date createdOn;

    private int lastModifiedBy;

    private Date lastModifiedOn;

    @Pattern(regexp = "^(\\\\+\\\\d{1,4})?\\\\d{10,15}$")
    private String entityPhoneNo;

    private Date updatedOn;

    private String entityNameBil=entityName;

    private String entityShortName=entityShortname;

    private int bankType;
}

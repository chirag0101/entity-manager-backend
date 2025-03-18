package com.iris.entitymanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class UpdateReturnDTO {
    @NotEmpty(message = "P014")
    private String returnName;

    @NotBlank(message = "P015")
    private String returnCode;

    @NotBlank(message = "P016")
    private String frequencyCode;

    private List<Long> returnTypeList;

    private Long maxAllowedRevisions;

    private Boolean allowRevision;

    private Boolean isActive;

    public UpdateReturnDTO() {
    }

    public UpdateReturnDTO(String returnName, String returnCode, String frequencyCode, List<Long> returnTypeList, Long maxAllowedRevisions, Boolean allowRevision, Boolean isActive) {
        this.returnName = returnName;
        this.returnCode = returnCode;
        this.frequencyCode = frequencyCode;
        this.returnTypeList = returnTypeList;
        this.maxAllowedRevisions = maxAllowedRevisions;
        this.allowRevision = allowRevision;
        this.isActive = isActive;
    }

    public String getReturnName() {
        return returnName;
    }

    public void setReturnName(String returnName) {
        this.returnName = returnName;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getFrequencyCode() {
        return frequencyCode;
    }

    public void setFrequencyCode(String frequencyCode) {
        this.frequencyCode = frequencyCode;
    }

    public List<Long> getReturnTypeList() {
        return returnTypeList;
    }

    public void setReturnTypeList(List<Long> returnTypeList) {
        this.returnTypeList = returnTypeList;
    }

    public Long getMaxAllowedRevisions() {
        return maxAllowedRevisions;
    }

    public void setMaxAllowedRevisions(Long maxAllowedRevisions) {
        this.maxAllowedRevisions = maxAllowedRevisions;
    }

    public Boolean getAllowRevision() {
        return allowRevision;
    }

    public void setAllowRevision(Boolean allowRevision) {
        this.allowRevision = allowRevision;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
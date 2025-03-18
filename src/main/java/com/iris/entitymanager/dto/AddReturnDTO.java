package com.iris.entitymanager.dto;

import java.util.List;

public class AddReturnDTO {
    private String returnName;
    private String returnCode;
    private Long frequencyId;
    private List<Long> returnTypeList;
    private Long maxAllowedRevisions;
    private Boolean allowRevision;
    private Boolean isActive;

    public AddReturnDTO() {
    }

    public AddReturnDTO(String returnName, String returnCode, Long frequencyId, List<Long> returnTypeList, Long maxAllowedRevisions, Boolean allowRevision, Boolean isActive) {
        this.returnName = returnName;
        this.returnCode = returnCode;
        this.frequencyId = frequencyId;
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

    public Long getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(Long frequencyId) {
        this.frequencyId = frequencyId;
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
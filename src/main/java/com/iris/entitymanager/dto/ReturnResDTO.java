package com.iris.entitymanager.dto;

import java.util.Date;

public class ReturnResDTO {
    private Long returnId;

    private String returnName;

    private String returnCode;

    private String modRetCode;

    private Boolean isParent;

    private Boolean isActive;

    private Boolean allowRevision;

    private Date createdOn;

    private Date lastModifiedOn;

    private Date lastApprovedOn;

    private Date lastUpdateOn;

    private Boolean isBulkUpload;

    private Boolean isNonXbrl;

    private String formulaFileName;

    private String delayCriteriaFileName;

    private String returnTemplateName;

    private Long errorCount;

    private Long warningCount;

    private String excelReadJson;

    private Long maxRevisionReqDays;

    private Long maxUnlockReqDays;

    private Long maxRevisionCount;

    private String oldReturnCode;

    private String returnDocId;

    private Boolean applicableForDynamicWebform;

    private String returnDocIdFailed;

    private Boolean isLotApplicable;

    private Boolean allowNillFilling;

    //
    private Long frequencyId;

    private String frequencyName;

    private String description;

    private Boolean frequencyIsActive;

    private Date frequencyCreatedOn;

    private Date frequencyLastModifiedOn;

    private Date frequencyLastApprovedOn;

    private Date frequencyLastUpdateOn;

    private String frequencyCode;
    //
    private Long userId;

    private String userName;

    public ReturnResDTO() {
    }

    public ReturnResDTO(Long returnId, String returnName, String returnCode, String modRetCode, Boolean isParent, Boolean isActive, Boolean allowRevision, Date createdOn, Date lastModifiedOn, Date lastApprovedOn, Date lastUpdateOn, Boolean isBulkUpload, Boolean isNonXbrl, String formulaFileName, String delayCriteriaFileName, String returnTemplateName, Long errorCount, Long warningCount, String excelReadJson, Long maxRevisionReqDays, Long maxUnlockReqDays, Long maxRevisionCount, String oldReturnCode, String returnDocId, Boolean applicableForDynamicWebform, String returnDocIdFailed, Boolean isLotApplicable, Boolean allowNillFilling, Long frequencyId, String frequencyName, String description, Boolean frequencyIsActive, Date frequencyCreatedOn, Date frequencyLastModifiedOn, Date frequencyLastApprovedOn, Date frequencyLastUpdateOn, String frequencyCode, Long userId, String userName) {
        this.returnId = returnId;
        this.returnName = returnName;
        this.returnCode = returnCode;
        this.modRetCode = modRetCode;
        this.isParent = isParent;
        this.isActive = isActive;
        this.allowRevision = allowRevision;
        this.createdOn = createdOn;
        this.lastModifiedOn = lastModifiedOn;
        this.lastApprovedOn = lastApprovedOn;
        this.lastUpdateOn = lastUpdateOn;
        this.isBulkUpload = isBulkUpload;
        this.isNonXbrl = isNonXbrl;
        this.formulaFileName = formulaFileName;
        this.delayCriteriaFileName = delayCriteriaFileName;
        this.returnTemplateName = returnTemplateName;
        this.errorCount = errorCount;
        this.warningCount = warningCount;
        this.excelReadJson = excelReadJson;
        this.maxRevisionReqDays = maxRevisionReqDays;
        this.maxUnlockReqDays = maxUnlockReqDays;
        this.maxRevisionCount = maxRevisionCount;
        this.oldReturnCode = oldReturnCode;
        this.returnDocId = returnDocId;
        this.applicableForDynamicWebform = applicableForDynamicWebform;
        this.returnDocIdFailed = returnDocIdFailed;
        this.isLotApplicable = isLotApplicable;
        this.allowNillFilling = allowNillFilling;
        this.frequencyId = frequencyId;
        this.frequencyName = frequencyName;
        this.description = description;
        this.frequencyIsActive = frequencyIsActive;
        this.frequencyCreatedOn = frequencyCreatedOn;
        this.frequencyLastModifiedOn = frequencyLastModifiedOn;
        this.frequencyLastApprovedOn = frequencyLastApprovedOn;
        this.frequencyLastUpdateOn = frequencyLastUpdateOn;
        this.frequencyCode = frequencyCode;
        this.userId = userId;
        this.userName = userName;
    }

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
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

    public String getModRetCode() {
        return modRetCode;
    }

    public void setModRetCode(String modRetCode) {
        this.modRetCode = modRetCode;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean parent) {
        isParent = parent;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Boolean getAllowRevision() {
        return allowRevision;
    }

    public void setAllowRevision(Boolean allowRevision) {
        this.allowRevision = allowRevision;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public Date getLastApprovedOn() {
        return lastApprovedOn;
    }

    public void setLastApprovedOn(Date lastApprovedOn) {
        this.lastApprovedOn = lastApprovedOn;
    }

    public Date getLastUpdateOn() {
        return lastUpdateOn;
    }

    public void setLastUpdateOn(Date lastUpdateOn) {
        this.lastUpdateOn = lastUpdateOn;
    }

    public Boolean getIsBulkUpload() {
        return isBulkUpload;
    }

    public void setIsBulkUpload(Boolean bulkUpload) {
        isBulkUpload = bulkUpload;
    }

    public Boolean getIsNonXbrl() {
        return isNonXbrl;
    }

    public void setIsNonXbrl(Boolean nonXbrl) {
        isNonXbrl = nonXbrl;
    }

    public String getFormulaFileName() {
        return formulaFileName;
    }

    public void setFormulaFileName(String formulaFileName) {
        this.formulaFileName = formulaFileName;
    }

    public String getDelayCriteriaFileName() {
        return delayCriteriaFileName;
    }

    public void setDelayCriteriaFileName(String delayCriteriaFileName) {
        this.delayCriteriaFileName = delayCriteriaFileName;
    }

    public String getReturnTemplateName() {
        return returnTemplateName;
    }

    public void setReturnTemplateName(String returnTemplateName) {
        this.returnTemplateName = returnTemplateName;
    }

    public Long getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Long errorCount) {
        this.errorCount = errorCount;
    }

    public Long getWarningCount() {
        return warningCount;
    }

    public void setWarningCount(Long warningCount) {
        this.warningCount = warningCount;
    }

    public String getExcelReadJson() {
        return excelReadJson;
    }

    public void setExcelReadJson(String excelReadJson) {
        this.excelReadJson = excelReadJson;
    }

    public Long getMaxRevisionReqDays() {
        return maxRevisionReqDays;
    }

    public void setMaxRevisionReqDays(Long maxRevisionReqDays) {
        this.maxRevisionReqDays = maxRevisionReqDays;
    }

    public Long getMaxUnlockReqDays() {
        return maxUnlockReqDays;
    }

    public void setMaxUnlockReqDays(Long maxUnlockReqDays) {
        this.maxUnlockReqDays = maxUnlockReqDays;
    }

    public Long getMaxRevisionCount() {
        return maxRevisionCount;
    }

    public void setMaxRevisionCount(Long maxRevisionCount) {
        this.maxRevisionCount = maxRevisionCount;
    }

    public String getOldReturnCode() {
        return oldReturnCode;
    }

    public void setOldReturnCode(String oldReturnCode) {
        this.oldReturnCode = oldReturnCode;
    }

    public String getReturnDocId() {
        return returnDocId;
    }

    public void setReturnDocId(String returnDocId) {
        this.returnDocId = returnDocId;
    }

    public Boolean getApplicableForDynamicWebform() {
        return applicableForDynamicWebform;
    }

    public void setApplicableForDynamicWebform(Boolean applicableForDynamicWebform) {
        this.applicableForDynamicWebform = applicableForDynamicWebform;
    }

    public String getReturnDocIdFailed() {
        return returnDocIdFailed;
    }

    public void setReturnDocIdFailed(String returnDocIdFailed) {
        this.returnDocIdFailed = returnDocIdFailed;
    }

    public Boolean getIsLotApplicable() {
        return isLotApplicable;
    }

    public void setIsLotApplicable(Boolean lotApplicable) {
        isLotApplicable = lotApplicable;
    }

    public Boolean getAllowNillFilling() {
        return allowNillFilling;
    }

    public void setAllowNillFilling(Boolean allowNillFilling) {
        this.allowNillFilling = allowNillFilling;
    }

    public Long getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(Long frequencyId) {
        this.frequencyId = frequencyId;
    }

    public String getFrequencyName() {
        return frequencyName;
    }

    public void setFrequencyName(String frequencyName) {
        this.frequencyName = frequencyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFrequencyIsActive() {
        return frequencyIsActive;
    }

    public void setFrequencyIsActive(Boolean frequencyIsActive) {
        this.frequencyIsActive = frequencyIsActive;
    }

    public Date getFrequencyCreatedOn() {
        return frequencyCreatedOn;
    }

    public void setFrequencyCreatedOn(Date frequencyCreatedOn) {
        this.frequencyCreatedOn = frequencyCreatedOn;
    }

    public Date getFrequencyLastModifiedOn() {
        return frequencyLastModifiedOn;
    }

    public void setFrequencyLastModifiedOn(Date frequencyLastModifiedOn) {
        this.frequencyLastModifiedOn = frequencyLastModifiedOn;
    }

    public Date getFrequencyLastApprovedOn() {
        return frequencyLastApprovedOn;
    }

    public void setFrequencyLastApprovedOn(Date frequencyLastApprovedOn) {
        this.frequencyLastApprovedOn = frequencyLastApprovedOn;
    }

    public Date getFrequencyLastUpdateOn() {
        return frequencyLastUpdateOn;
    }

    public void setFrequencyLastUpdateOn(Date frequencyLastUpdateOn) {
        this.frequencyLastUpdateOn = frequencyLastUpdateOn;
    }

    public String getFrequencyCode() {
        return frequencyCode;
    }

    public void setFrequencyCode(String frequencyCode) {
        this.frequencyCode = frequencyCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
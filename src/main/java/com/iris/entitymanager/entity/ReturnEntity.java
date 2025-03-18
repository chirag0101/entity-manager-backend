package com.iris.entitymanager.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TBL_RETURN")
public class ReturnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RETURN_ID")
    private Long returnId;

    @Column(name = "RETURN_NAME")
    private String returnName;

    @Column(name = "RETURN_CODE")
    private String returnCode;

    @Column(name = "MOD_RET_CODE")
    private String modRetCode;

    @OneToOne
    @JoinColumn(name = "FREQUENCY_ID_FK")
    private FrequencyEntity frequencyIdFk; //JOIN

    @Column(name = "IS_PARENT")
    private Boolean isParent;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "ALLOW_REVISION")
    private Boolean allowRevision;

    @OneToOne
    @JoinColumn(name = "CREATED_BY_FK")
    private UserEntity createdByFk; //JOIN

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @OneToOne
    @JoinColumn(name = "LAST_MODIFIED_BY_FK")
    private UserEntity lastModifiedByFk;

    @Column(name = "LAST_MODIFIED_ON")
    private Date lastModifiedOn;

    @OneToOne
    @JoinColumn(name = "LAST_APPROVED_BY_FK")
    private UserEntity lastApprovedByFk;

    @Column(name = "LAST_APPROVED_ON")
    private Date lastApprovedOn;

    @Column(name = "LAST_UPDATE_ON")
    private Date lastUpdateOn;

    @Column(name = "IS_BULK_UPLOAD")
    private Boolean isBulkUpload;

    @Column(name = "IS_NON_XBRL")
    private Boolean isNonXbrl;

    @Column(name = "FORMULA_FILE_NAME")
    private String formulaFileName;

    @Column(name = "DELAY_CRITERIA_FILE_NAME")
    private String delayCriteriaFileName;

    @Column(name = "RETURN_TEMPLATE_NAME")
    private String returnTemplateName;

    @Column(name = "ERROR_COUNT")
    private Long errorCount;

    @Column(name = "WARNING_COUNT")
    private Long warningCount;

    @Column(name = "EXCEL_READ_JSON")
    private String excelReadJson;

    @Column(name = "MAX_REVISION_REQ_DAYS")
    private Long maxRevisionReqDays;

    @Column(name = "MAX_UNLOCK_REQ_DAYS")
    private Long maxUnlockReqDays;

    @Column(name = "MAX_REVISION_COUNT")
    private Long maxRevisionCount;

    @Column(name = "OLD_RETURN_CODE")
    private String oldReturnCode;

    @Column(name = "RETURN_DOC_ID")
    private String returnDocId;

    @Column(name = "APPLICABLE_FOR_DYNAMIC_WEBFORM")
    private Boolean applicableForDynamicWebform;

    @Column(name = "RETURN_DOC_ID_FAILED")
    private String returnDocIdFailed;

    @Column(name = "IS_LOT_APPLICABLE")
    private Boolean isLotApplicable;

    @Column(name = "ALLOW_NILL_FILLING")
    private Boolean allowNillFilling;

    public ReturnEntity() {
    }

    public ReturnEntity(Long returnId, String returnName, String returnCode, String modRetCode, FrequencyEntity frequencyIdFk, Boolean isParent, Boolean isActive, UserEntity createdByFk, Boolean allowRevision, Date createdOn, UserEntity lastModifiedByFk, Date lastModifiedOn, UserEntity lastApprovedByFk, Date lastApprovedOn, Date lastUpdateOn, Boolean isBulkUpload, Boolean isNonXbrl, String formulaFileName, String delayCriteriaFileName, String returnTemplateName, Long errorCount, Long warningCount, String excelReadJson, Long maxRevisionReqDays, Long maxUnlockReqDays, Long maxRevisionCount, String oldReturnCode, String returnDocId, Boolean applicableForDynamicWebform, String returnDocIdFailed, Boolean isLotApplicable, Boolean allowNillFilling) {
        this.returnId = returnId;
        this.returnName = returnName;
        this.returnCode = returnCode;
        this.modRetCode = modRetCode;
        this.frequencyIdFk = frequencyIdFk;
        this.isParent = isParent;
        this.isActive = isActive;
        this.createdByFk = createdByFk;
        this.allowRevision = allowRevision;
        this.createdOn = createdOn;
        this.lastModifiedByFk = lastModifiedByFk;
        this.lastModifiedOn = lastModifiedOn;
        this.lastApprovedByFk = lastApprovedByFk;
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

    public FrequencyEntity getFrequencyIdFk() {
        return frequencyIdFk;
    }

    public void setFrequencyIdFk(FrequencyEntity frequencyIdFk) {
        this.frequencyIdFk = frequencyIdFk;
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

    public UserEntity getCreatedByFk() {
        return createdByFk;
    }

    public void setCreatedByFk(UserEntity createdByFk) {
        this.createdByFk = createdByFk;
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

    public UserEntity getLastModifiedByFk() {
        return lastModifiedByFk;
    }

    public void setLastModifiedByFk(UserEntity lastModifiedByFk) {
        this.lastModifiedByFk = lastModifiedByFk;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public UserEntity getLastApprovedByFk() {
        return lastApprovedByFk;
    }

    public void setLastApprovedByFk(UserEntity lastApprovedByFk) {
        this.lastApprovedByFk = lastApprovedByFk;
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
}
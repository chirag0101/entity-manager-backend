package com.iris.entitymanager.repository;

import com.iris.entitymanager.dto.ReturnResDTO;
import com.iris.entitymanager.entity.ReturnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReturnRepo extends JpaRepository<ReturnEntity, Long> {
    Optional<ReturnEntity> findByReturnCode(String returnCode);

    Optional<ReturnEntity> findByReturnName(String returnName);

    @Query("SELECT new com.iris.entitymanager.dto.ReturnResDTO(re.returnId,re.returnName,re.returnCode,re.modRetCode,re.isParent,re.isActive,re.allowRevision,re.createdOn,re.lastModifiedOn,re.lastApprovedOn,re.lastUpdateOn,re.isBulkUpload,re.isNonXbrl,re.formulaFileName,re.delayCriteriaFileName,re.returnTemplateName,re.errorCount,re.warningCount,re.excelReadJson,re.maxRevisionReqDays,re.maxUnlockReqDays,re.maxRevisionCount,re.oldReturnCode,re.returnDocId,re.applicableForDynamicWebform,re.returnDocIdFailed,re.isLotApplicable,re.allowNillFilling,ft.frequencyId,ft.frequencyName,ft.description,ft.isActive,ft.createdOn,ft.lastModifiedOn,ft.lastApprovedOn,ft.lastUpdateOn,ft.frequencyCode,ue.userId,ue.userName)"
            + "FROM ReturnEntity re "
            + "LEFT JOIN FrequencyEntity ft ON re.frequencyIdFk.frequencyId=ft.frequencyId "
            + "LEFT JOIN UserEntity ue ON ue.userId=ft.createdByFk.userId")
    List<ReturnResDTO> findAllReturns();
}
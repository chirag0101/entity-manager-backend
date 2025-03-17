package com.iris.entitymanager.service;

import com.iris.entitymanager.dto.AddReturnDTO;
import com.iris.entitymanager.dto.ApiResponse;
import com.iris.entitymanager.dto.UpdateReturnDTO;
import com.iris.entitymanager.entity.*;
import com.iris.entitymanager.exceptions.GlobalException;
import com.iris.entitymanager.repository.*;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReturnService {
    @Autowired
    private ReturnRepo returnRepo;

    @Autowired
    private ReturnTypeRepo returnTypeRepo;

    @Autowired
    private UserEntityRepo userRepo;

    @Autowired
    private FrequencyRepo frequencyRepo;

    @Autowired
    private ReturnReturnTypeRepo returnReturnTypeRepo;

    @Transactional
    public ResponseEntity<?> addReturn(AddReturnDTO returnDTO) {
        try {
            // Check if the entity with the same name already exists
            Optional<ReturnEntity> returnInDb = returnRepo.findByReturnName(returnDTO.getReturnName());
            if (returnInDb.isPresent()) {
                throw new GlobalException("E302"); // Entity already exists
            }

            UserEntity userEntity = userRepo.findByUserId(1L);

            ReturnEntity returnEntity = getReturnEntity(returnDTO, userEntity);

            returnRepo.save(returnEntity);

            if (returnDTO.getReturnTypeList().isEmpty()) {
                throw new GlobalException("Return Type List can't be Empty!");
            }

            for (int i = 0; i < returnDTO.getReturnTypeList().size(); i++) {

                ReturnReturnTypeEntity returnReturnType = new ReturnReturnTypeEntity();

                returnReturnType.setReturnIdFk(returnEntity);

                Optional<ReturnTypeEntity> returnType = returnTypeRepo.findByReturnTypeIdAndIsActive((returnDTO.getReturnTypeList().get(i)), true);
                if (returnType.isEmpty()) {
                    throw new GlobalException("Invalid Return Type Id or Id inactive!");
                }

                returnType.ifPresent(returnReturnType::setReturnTypeIdFk);
                returnReturnType.setIsActive(returnDTO.getIsActive());
                returnReturnType.setModifiedOn(null);
                returnReturnType.setModifiedBy(userEntity.getUserId());

                returnReturnTypeRepo.saveAndFlush(returnReturnType);
            }

            return new ResponseEntity<>(new ApiResponse<>(), HttpStatus.OK);
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }

    //private method for setting returnEntity internally
    private ReturnEntity getReturnEntity(AddReturnDTO returnDTO, UserEntity userEntity) {
        ReturnEntity returnEntity = new ReturnEntity();
        returnEntity.setReturnName(returnDTO.getReturnName());
        returnEntity.setReturnCode(returnDTO.getReturnCode());
        returnEntity.setModRetCode(null);

        //checking if the given frequency is present or not, if yes than map it
        //mapping frequencyEntityId in frequency table
        Optional<FrequencyEntity> frequency = frequencyRepo.findByFrequencyId(returnDTO.getFrequencyId());
        if (frequency.isEmpty()) {
            throw new GlobalException("Frequency Not Found!");
        }
        returnEntity.setFrequencyIdFk(frequency.get());

        returnEntity.setIsParent(false);
        returnEntity.setIsActive(returnDTO.getIsActive());
        returnEntity.setAllowRevision(returnDTO.getAllowRevision());
        returnEntity.setCreatedByFk(userEntity);
        returnEntity.setCreatedOn(new Date());
        returnEntity.setLastModifiedByFk(null);
        returnEntity.setLastModifiedOn(null);
        returnEntity.setLastApprovedByFk(userEntity);
        returnEntity.setLastApprovedOn(null);
        returnEntity.setLastUpdateOn(null);
        returnEntity.setIsBulkUpload(false);
        returnEntity.setIsNonXbrl(false);
        returnEntity.setFormulaFileName(null);
        returnEntity.setDelayCriteriaFileName(null);
        returnEntity.setReturnTemplateName(null);
        returnEntity.setErrorCount(0L);
        returnEntity.setWarningCount(0L);
        returnEntity.setExcelReadJson(null);
        returnEntity.setMaxRevisionReqDays(0L);
        returnEntity.setMaxUnlockReqDays(0L);
        returnEntity.setMaxRevisionCount(returnDTO.getMaxAllowedRevisions());
        returnEntity.setOldReturnCode(null);
        returnEntity.setReturnDocId(null);
        returnEntity.setApplicableForDynamicWebform(false);
        returnEntity.setReturnDocIdFailed(null);
        returnEntity.setIsLotApplicable(false);
        returnEntity.setAllowNillFilling(false);
        return returnEntity;
    }

    public ResponseEntity<?> getAllReturns() {
        try {
            List<ReturnEntity> returnsInDb = returnRepo.findAll();
            List<AddReturnDTO> returns = new ArrayList<>();

            for (ReturnEntity r : returnsInDb) {
                List<Long> returnReturnTypeEntityList = returnReturnTypeRepo.findByReturnIdFk(r.getReturnId());
                returns.add(new AddReturnDTO(r.getReturnName(), r.getReturnCode(), r.getFrequencyIdFk().getFrequencyId(), returnReturnTypeEntityList, r.getMaxRevisionCount(), r.getAllowRevision(), r.getIsActive()));
            }

            return new ResponseEntity<>(new ApiResponse<>(returns), HttpStatus.OK);
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }

    @Transactional
    public ResponseEntity<?> updateReturn(UpdateReturnDTO updateReturnDTO) {
        try {
            //checking if return exists with the returnCode
            Optional<ReturnEntity> returnInDB = returnRepo.findByReturnCode(updateReturnDTO.getReturnCode());
            if (returnInDB.isEmpty()) {
                throw new GlobalException("E404");
            }

            UserEntity user = userRepo.findByUserId(1L);

            //updating return record
            ReturnEntity toUpdateReturn = returnInDB.get();
            toUpdateReturn.setReturnName(updateReturnDTO.getReturnName());

            Optional<FrequencyEntity> frequency = frequencyRepo.findByFrequencyCode(updateReturnDTO.getFrequencyCode());
            if (frequency.isEmpty()) {
                throw new GlobalException("Frequency Not Found!");
            }
            toUpdateReturn.setFrequencyIdFk(frequency.get());

            toUpdateReturn.setMaxRevisionCount(updateReturnDTO.getMaxAllowedRevisions());
            toUpdateReturn.setAllowRevision(updateReturnDTO.getAllowRevision());
            toUpdateReturn.setIsActive(updateReturnDTO.getIsActive());
            toUpdateReturn.setLastUpdateOn(new Date());
            toUpdateReturn.setLastApprovedOn(new Date());
            toUpdateReturn.setLastApprovedByFk(user);
            toUpdateReturn.setLastModifiedByFk(user);
            toUpdateReturn.setLastModifiedOn(new Date());

            returnRepo.save(toUpdateReturn);

            if (updateReturnDTO.getReturnTypeList().isEmpty()) {
                throw new GlobalException("Return Type List can't be Empty!");
            }

            //getting all return returnReturnType ids for the given return id
            List<Long> returnTypeIds = returnReturnTypeRepo.findByReturnIdFk(toUpdateReturn.getReturnId());

            //checking if all returnType ids of the given returnId exists in the given list in dto
            //if exists then check their active status
            //if active and exists in the list than ignore
            //if active and not exists then add after checking active status in returnType tbl
            //if not active in return type tbl then throw error
            //if not present in update list than set active status as false
            for (Long i : returnTypeIds) {
                if (updateReturnDTO.getReturnTypeList().contains(i)) {
                    ReturnReturnTypeEntity returnReturnType = returnReturnTypeRepo.findByReturnTypeIdFk(i);
                    if (!(returnTypeRepo.findByReturnTypeId(i).getIsActive())) {
                        throw new GlobalException("Invalid Return Type Id or Id inactive!");
                    }

                    if (!returnReturnType.getIsActive()) {
                        returnReturnType.setIsActive(true);
                    }
                    returnReturnTypeRepo.saveAndFlush(returnReturnType);
                } else if (!(returnTypeIds.contains(i))) {
                    ReturnReturnTypeEntity returnReturnType = new ReturnReturnTypeEntity();

                    Optional<ReturnTypeEntity> returnType = returnTypeRepo.findByReturnTypeIdAndIsActive(i, true);
                    if (returnType.isEmpty()) {
                        throw new GlobalException("Invalid Return Type Id or Id inactive!");
                    }

                    returnReturnType.setReturnIdFk(toUpdateReturn);
                    returnReturnType.setReturnTypeIdFk(returnType.get());
                    returnReturnType.setIsActive(true);
                    returnReturnType.setModifiedOn(new Date());
                    returnReturnType.setModifiedBy(toUpdateReturn.getCreatedByFk().getUserId());

                    returnReturnTypeRepo.saveAndFlush(returnReturnType);

                } else {
                    ReturnReturnTypeEntity returnReturnType = returnReturnTypeRepo.findByReturnTypeIdFk(i);
                    returnReturnType.setIsActive(false);
                    returnReturnTypeRepo.save(returnReturnType);
                }
            }

            return new ResponseEntity<>(new ApiResponse<>(), HttpStatus.OK);
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }
}
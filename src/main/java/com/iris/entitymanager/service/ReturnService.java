package com.iris.entitymanager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iris.entitymanager.dto.AddReturnDTO;
import com.iris.entitymanager.dto.ApiResponse;
import com.iris.entitymanager.dto.UpdateReturnDTO;
import com.iris.entitymanager.entity.*;
import com.iris.entitymanager.exceptions.GlobalException;
import com.iris.entitymanager.repository.*;
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

    @Autowired
    private ReturnModRepo returnModRepo;

    @Transactional
    public ResponseEntity<?> addReturn(AddReturnDTO returnDTO) {
        try {
            // Check if the entity with the same name already exists
            Optional<ReturnEntity> returnInDb = returnRepo.findByReturnCode(returnDTO.getReturnCode());
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

            ObjectMapper objectMapper = new ObjectMapper();
            String prevData = objectMapper.writeValueAsString(returnInDB.get());

            ReturnMod returnMod = new ReturnMod();
            returnMod.setReturnIdFk(returnInDB.get());
            returnMod.setLastModifiedBy(returnInDB.get().getCreatedByFk().getUserId());
            returnMod.setPrevDataJson(prevData);
            returnMod.setLastModifiedOn(new Date());
            returnModRepo.save(returnMod);

            UserEntity user = userRepo.findByUserId(1L);

            //updating return record
            ReturnEntity toUpdateReturn = returnInDB.get();
            toUpdateReturn.setReturnName(updateReturnDTO.getReturnName());

            Optional<FrequencyEntity> frequency = frequencyRepo.findByFrequencyCode(updateReturnDTO.getFrequencyCode());
            if (frequency.isEmpty()) {
                throw new GlobalException("E011");
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
                throw new GlobalException("E009");
            }

            //getting all return returnReturnType ids for the given return id
            List<Long> returnTypeIds = returnReturnTypeRepo.findByReturnIdFk(toUpdateReturn.getReturnId());

            //getting all returnTypeIds from returnType table
            List<Long> defaultReturnTypeIds = returnTypeRepo.findAllIdsAndIsActive();

            //setting all isActive true to false
            for (Long i : returnTypeIds) {
                ReturnReturnTypeEntity returnReturnType = returnReturnTypeRepo.findByReturnTypeIdFk(i, toUpdateReturn.getReturnId());
                if (returnReturnType.getIsActive()) {
                    returnReturnType.setIsActive(false);
                    returnReturnType.setModifiedOn(new Date());
                }
                returnReturnTypeRepo.saveAndFlush(returnReturnType);
            }

            /*
                1) looping over the request returnType list
                2) checking if it exists in both the lists i.e. returnType_tbl & returnReturnType_tbl & isActive in returnType_tbl & isActive is false, if yes than set it's status as active
                3) checking if it exists in returnType_tbl & isActive but not present in returnReturnType_tbl so add new entry in returnReturnType_tbl
                4) if is inactive in returnType_tbl than throw exception
                5)
            */

            for (Long i : updateReturnDTO.getReturnTypeList()) {

                //if return type exists in both list i.e. (list of all active returnTypes & list of current returnReturnType returnIds) then set it as active
                if (defaultReturnTypeIds.contains(i) && returnTypeIds.contains(i)) {
                    ReturnReturnTypeEntity returnReturnType = returnReturnTypeRepo.findByReturnTypeIdFk(i, toUpdateReturn.getReturnId());

                    returnReturnType.setIsActive(true);
                    returnReturnType.setModifiedOn(new Date());

                    returnReturnTypeRepo.saveAndFlush(returnReturnType);
                } else if (!(defaultReturnTypeIds.contains(i))) {   //if the returnTypeId doesn't exist in returnType tbl
                    throw new GlobalException("E010");
                } else if ((defaultReturnTypeIds.contains(i)) && !(returnTypeIds.contains(i))) {    //if returnType exists in returnType_tbl & isActive but not in current returnReturnType's_tbl then save new entry
                    ReturnReturnTypeEntity newReturnReturnType = new ReturnReturnTypeEntity();
                    newReturnReturnType.setReturnIdFk(toUpdateReturn);
                    newReturnReturnType.setReturnTypeIdFk(returnTypeRepo.findByReturnTypeId(i));
                    newReturnReturnType.setIsActive(true);
                    newReturnReturnType.setModifiedOn(null);
                    newReturnReturnType.setModifiedBy(user.getUserId());
                    returnReturnTypeRepo.saveAndFlush(newReturnReturnType);
                } else {
                    ReturnReturnTypeEntity returnReturnType = returnReturnTypeRepo.findByReturnTypeIdFk(i, toUpdateReturn.getReturnId());
                    returnReturnType.setIsActive(false);
                    returnReturnType.setModifiedOn(new Date());
                    returnReturnTypeRepo.save(returnReturnType);
                }
            }

            return new ResponseEntity<>(new ApiResponse<>(), HttpStatus.OK);
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }
}
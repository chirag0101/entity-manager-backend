package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.ReturnReturnTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnReturnTypeRepo extends JpaRepository<ReturnReturnTypeEntity, Long> {
    @Query("SELECT rrte.returnTypeIdFk.returnTypeId FROM ReturnReturnTypeEntity rrte WHERE rrte.returnIdFk.returnId=:id ORDER BY rrte.returnTypeIdFk.returnTypeId")
    List<Long> findByReturnIdFk(Long id);

    //List<ReturnReturnTypeEntity> findAllByReturnIdFk(Long id);

    @Query("FROM ReturnReturnTypeEntity rrte WHERE rrte.returnTypeIdFk.returnTypeId=:returnTypeId AND rrte.returnIdFk.returnId=:returnId")
    ReturnReturnTypeEntity findByReturnTypeIdFk(Long returnTypeId,Long returnId);

//    @Query("rrte.returnTypeIdFk.returnTypeId FROM ReturnReturnTypeEntity rrte WHERE rrte.returnIdFk.returnId=:id")
//    List<Integer> findAllReturnTypeIds(Long id);
}

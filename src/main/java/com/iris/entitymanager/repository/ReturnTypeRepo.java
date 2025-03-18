package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.ReturnTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReturnTypeRepo extends JpaRepository<ReturnTypeEntity, Long> {
    Optional<ReturnTypeEntity> findByReturnTypeIdAndIsActive(Long id, Boolean isActive);

    ReturnTypeEntity findByReturnTypeId(Long id);

    @Query("SELECT rte.returnTypeId FROM ReturnTypeEntity rte WHERE rte.isActive=true")
    List<Long> findAllIdsAndIsActive();
}
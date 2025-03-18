package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.ReturnType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReturnTypeRepo extends JpaRepository<ReturnType, Long> {
    Optional<ReturnType> findByReturnTypeIdAndIsActive(Long id, Boolean isActive);

    ReturnType findByReturnTypeId(Long id);

    @Query("SELECT rte.returnTypeId FROM ReturnType rte WHERE rte.isActive=true")
    List<Long> findAllIdsAndIsActive();
}
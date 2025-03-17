package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.ReturnTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReturnTypeRepo extends JpaRepository<ReturnTypeEntity, Long> {
    Optional<ReturnTypeEntity> findByReturnTypeIdAndIsActive(Long id, Boolean isActive);
    ReturnTypeEntity findByReturnTypeId(Long id);
}
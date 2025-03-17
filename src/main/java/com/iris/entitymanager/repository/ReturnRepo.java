package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.ReturnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReturnRepo extends JpaRepository<ReturnEntity, Long> {
    Optional<ReturnEntity> findByReturnCode(String returnCode);
    Optional<ReturnEntity> findByReturnName(String returnName);
}

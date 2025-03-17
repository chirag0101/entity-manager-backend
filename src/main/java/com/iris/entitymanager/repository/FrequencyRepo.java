package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.FrequencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FrequencyRepo extends JpaRepository<FrequencyEntity,Long> {
    Optional<FrequencyEntity> findByFrequencyId(Long id);

    Optional<FrequencyEntity> findByFrequencyCode(String code);
}
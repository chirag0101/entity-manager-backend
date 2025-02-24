package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.EntityLabelModentity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelModRepository extends JpaRepository<EntityLabelModentity, Integer> {
}

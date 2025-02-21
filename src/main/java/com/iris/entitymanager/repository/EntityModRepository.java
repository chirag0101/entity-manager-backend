package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.EntityModentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityModRepository extends JpaRepository<EntityModentity, Integer> {
//    EntityModentity findByEntityIdFk(Integer entityIdFk);
}

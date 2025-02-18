package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.Entityentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntityRepository extends JpaRepository<Entityentity, Integer> {
    Optional<Entityentity> findById(int entityId);
}

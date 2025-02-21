package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.EntityModentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityModRepository extends JpaRepository<EntityModentity, Integer> {
    @Query("FROM EntityModentity ORDER BY lastModifiedOn DESC")
    List<EntityModentity> findAll();
}

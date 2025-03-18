package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.EntityMod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityModRepository extends JpaRepository<EntityMod, Integer> {
    @Query("FROM EntityMod WHERE entityIdFk.id=?1 ORDER BY lastModifiedOn DESC")
    List<EntityMod> findAll(int id);

//    List<EntityMod> findByApiName(String apiName);
}
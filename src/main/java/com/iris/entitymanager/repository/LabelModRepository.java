package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.EntityLabelModentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelModRepository extends JpaRepository<EntityLabelModentity, Integer> {
    @Query("from EntityLabelModentity where entityLabelIdFk.labelEntityId=?1")
    List<EntityLabelModentity> findByEntityLabelIdFk(Integer labelId);
}

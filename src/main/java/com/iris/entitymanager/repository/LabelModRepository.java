package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.EntityLabelMod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelModRepository extends JpaRepository<EntityLabelMod, Integer> {
    @Query("from EntityLabelMod where entityLabelIdFk.labelEntityId=?1")
    List<EntityLabelMod> findByEntityLabelIdFk(Integer labelId);
}

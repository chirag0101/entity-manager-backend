package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.EntityLabelentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LabelRepository extends JpaRepository<EntityLabelentity, Integer> {
    @Query(value = "from EntityLabelentity ele left join EntityLabelMod elm on ele.entityId=elm.entityLabelEntity.entityId where entityIdFk.id=?1")
    Optional<EntityLabelentity> findById(Integer entityIdFk);

    @Query("from EntityLabelentity where langIdFk=?1")
    List<EntityLabelentity> findBylangIdFk(Integer langIdFk);
}

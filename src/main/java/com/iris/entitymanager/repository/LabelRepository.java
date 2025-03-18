package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.EntityLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabelRepository extends JpaRepository<EntityLabel, Integer> {
    @Query(value = "from EntityLabel where entityIdFk.id=?1")
    Optional<EntityLabel> findById(Integer entityIdFk);

    @Query("from EntityLabel where langIdFk=?1")
    List<EntityLabel> findBylangIdFk(Integer langIdFk);
}
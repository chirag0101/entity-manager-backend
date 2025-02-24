package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.LangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LangRepository extends JpaRepository<LangEntity, Integer> {
    //    @Query("isActive from LangEntity where language=?1")
    @Query("SELECT l.isActive FROM LangEntity l WHERE l.language = ?1")
    Boolean findByisActive(String language);

    @Query("SELECT l.langId FROM LangEntity l WHERE l.language = ?1")
    Integer findByLanguage(String language);
}

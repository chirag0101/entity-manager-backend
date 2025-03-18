package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.LangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LangRepository extends JpaRepository<LangEntity, Integer> {
    //    @Query("isActive from LangEntity where language=?1")
    //@Query("SELECT CASE WHEN l.isActive = 1 THEN true ELSE false END FROM LangEntity l WHERE l.language = ?1")
//    Optional<LangEntity> findByIsActive(String language);

    @Query("FROM LangEntity WHERE language=?1")
    Optional<LangEntity> findByLanguageName(String language);

    @Query("SELECT l.langId FROM LangEntity l WHERE l.language = ?1")
    Integer findByLanguage(String language);

    @Query("from LangEntity where isActive=true")
    List<LangEntity> findAllisActive();
}

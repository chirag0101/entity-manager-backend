package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.Lang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LangRepository extends JpaRepository<Lang, Integer> {
    //    @Query("isActive from Lang where language=?1")
    //@Query("SELECT CASE WHEN l.isActive = 1 THEN true ELSE false END FROM Lang l WHERE l.language = ?1")
//    Optional<Lang> findByIsActive(String language);

    @Query("FROM Lang WHERE language=?1")
    Optional<Lang> findByLanguageName(String language);

    @Query("SELECT l.langId FROM Lang l WHERE l.language = ?1")
    Integer findByLanguage(String language);

    @Query("from Lang where isActive=true")
    List<Lang> findAllisActive();
}

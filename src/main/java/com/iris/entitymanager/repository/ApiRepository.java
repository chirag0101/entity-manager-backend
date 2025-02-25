package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.Apientity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ApiRepository extends JpaRepository<Apientity,String> {
    @Query("from Apientity where apiName=?1")
    Apientity findByApiName(String apiName);
}

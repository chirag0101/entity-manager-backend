package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.ApiNameWithURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApiRepository extends JpaRepository<ApiNameWithURL, String> {
    @Query("from ApiNameWithURL where apiName=?1")
    ApiNameWithURL findByApiName(String apiName);
}

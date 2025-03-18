package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.ReturnMod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnModRepo extends JpaRepository<ReturnMod, Long> {
}

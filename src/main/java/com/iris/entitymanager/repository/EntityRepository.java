package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.Entityentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends JpaRepository<Entityentity,Integer> {
}

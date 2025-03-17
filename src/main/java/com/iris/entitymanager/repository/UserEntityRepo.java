package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity,Long> {
   UserEntity findByUserId(Long id);
}

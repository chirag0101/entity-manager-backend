package com.iris.entitymanager.repository;

import com.iris.entitymanager.entity.Errorentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ErrorRepository extends JpaRepository<Errorentity,String> {
//    List<Errorentity> findByErrorCode();
}

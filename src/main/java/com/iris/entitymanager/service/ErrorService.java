//package com.iris.entitymanager.service;
//
//import com.iris.entitymanager.entity.Errorentity;
//import com.iris.entitymanager.repository.ErrorRepository;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class ErrorService {
//
//    @Autowired
//    private ErrorRepository errorRepository;
//    public Map<String,String> error=new HashMap<>();
//
//    @PostConstruct
//    public void init(){
//        List<Errorentity> errorList=errorRepository.findAll();
//
//        for(Errorentity errorEntity:errorList){
////            System.out.println(errorEntity.getErrorCode()+" : "+errorEntity.getErrorMessage());
//            error.put(errorEntity.getErrorCode(),errorEntity.getErrorMessage());
//        }
//    }
//
//}

package com.iris.entitymanager.config;

import com.iris.entitymanager.entity.Errorentity;
import com.iris.entitymanager.repository.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class KeyLoader implements CommandLineRunner {

    @Autowired
    private ErrorRepository errorRepository;

    public static Map<String,String> error=new HashMap<>();

    @Override
    public void run(String... args) throws Exception {
        List<Errorentity> errorList=errorRepository.findAll();

        for(Errorentity errorEntity:errorList){
            System.out.println(errorEntity.getErrorCode()+" : "+errorEntity.getErrorMessage());
            error.put(errorEntity.getErrorCode(),errorEntity.getErrorMessage());
        }
    }
}

package com.iris.entitymanager.listener;

import com.iris.entitymanager.entity.Errorentity;
import com.iris.entitymanager.repository.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ErrorLoader implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ErrorRepository errorRepository;

    public Map<String, String> errors = new HashMap<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Errorentity> errorList = errorRepository.findAll();

        for (Errorentity errorEntity : errorList) {
            errors.put(errorEntity.getErrorCode(), errorEntity.getErrorMessage());
        }
    }
}

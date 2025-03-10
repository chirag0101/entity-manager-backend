package com.iris.entitymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class EntitymanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntitymanagerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplateBean() {
        return new RestTemplate();
    }
}

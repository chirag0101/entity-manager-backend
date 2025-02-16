package com.iris.entitymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class EntitymanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntitymanagerApplication.class, args);
	}

}

package com.iris.entitymanager.config;

import jakarta.persistence.Column;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class EntityManagerConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails chirag= User.builder()
                .username("Chirag")
                .password("{noop}cs@01")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager();
    }
}

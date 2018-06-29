package com.example.tenant.config;

import com.example.tenant.repository.handler.CategoryEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    CategoryEventHandler categoryEventHandler() {
        return new CategoryEventHandler();
    }
}

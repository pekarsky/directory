package com.petproject.configuration;

import com.petproject.datasvc.DocumentService;
import com.petproject.datasvc.DocumentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.petproject")
@EnableTransactionManagement
public class AppConfig {
    @Bean
    @SuppressWarnings("unused")
    public DocumentService documentService(){
        return new DocumentServiceImpl();
    }

}
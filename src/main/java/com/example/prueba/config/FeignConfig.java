package com.example.prueba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

/**
 * Clase FeignConfig.
 */
@Configuration
public class FeignConfig {

  
    /**
     * feignLoggerLevel.
     * 
     * @return Logger
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
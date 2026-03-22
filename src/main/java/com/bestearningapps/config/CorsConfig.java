package com.bestearningapps.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOriginPatterns("*")   // sab origin allow (Netlify, localhost)
                .allowedMethods("*")          // GET, POST, PUT, DELETE, OPTIONS
                .allowedHeaders("*")          // sab headers allow
                .allowCredentials(true);      // credentials allow
    }
}
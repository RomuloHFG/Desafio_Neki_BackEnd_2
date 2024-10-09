package com.example.login_auth_api.infra.security.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") 
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedOrigins("http://localhost:5173")
               // .allowedOrigins("http://localhost:3030")
               // .allowedOrigins("http://localhost:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}

//Essa configuração é importante para garantir que sua aplicação web funcione corretamente e de forma segura,
//permitindo que o front-end e o back-end se comuniquem sem problemas, mesmo que estejam em domínios diferentes.
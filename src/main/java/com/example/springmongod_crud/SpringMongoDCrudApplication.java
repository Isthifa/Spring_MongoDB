package com.example.springmongod_crud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Boot Crud MongoDB",version = "1.0",description = "mongo DB crud operation"))
public class SpringMongoDCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoDCrudApplication.class, args);
    }

}

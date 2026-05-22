package com.microservices.order_service.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI orderServiceOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Order Service API")
                                .description("REST API for Order Service Microservice")
                                .version("1.0")
                                .contact(
                                        new Contact()
                                                .name("Nikhil")
                                                .email("nikhil@example.com")
                                )
                                .license(
                                        new License()
                                                .name("Apache 2.0")
                                                .url("https://springdoc.org")
                                )
                )
                .externalDocs(
                        new ExternalDocumentation()
                                .description("Order Service Docs")
                                .url("https://github.com/")
                );
    }
}
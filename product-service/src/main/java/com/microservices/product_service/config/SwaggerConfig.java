package com.microservices.product_service.config;

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
    public OpenAPI productServiceOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Product Service API")
                                .description("REST API for Product Service Microservice")
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
                                .description("Project Documentation")
                                .url("https://github.com/")
                );
    }
}
package com.ec.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Ecommerce API",
                version = "1.0",
                description = "API documentation using springdoc-openapi-ui"
        )
)
public class OpenApiConfig {

}
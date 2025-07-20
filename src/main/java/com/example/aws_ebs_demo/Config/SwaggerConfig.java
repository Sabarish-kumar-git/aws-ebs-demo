package com.example.aws_ebs_demo.Config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger configuration class for the AWS EBS Demo application.
 * This class sets up the OpenAPI documentation for the REST API.
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AWS EBS Demo API")
                        .version("v1")
                        .description("API documentation for managing Person entities"));
    }
}

package com.example.aws_ebs_demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API Swagger dashboard",
				version = "1.0",
				description = "API documentation for REST API"
		)
)
public class AwsEbsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsEbsDemoApplication.class, args);
	}

}

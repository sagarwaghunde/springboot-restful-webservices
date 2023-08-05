package org.saga.springbootrestfulwebservices;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Rest API Doc",
				description = "Spring Boot Rest API Doc Description",
				version = "v1.0",
				contact = @Contact(
						name = "Sagar Waghunde",
						email = "sagar.waghunde@gmail.com",
						url = "https://google.com"
				),
				license = @License(
						name = "Practice 2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
			description = "Springboot User Management Docs",
			url = "https://www.linkedin.com"
		)
		
)
public class SpringbootRestfulWebservicesApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}

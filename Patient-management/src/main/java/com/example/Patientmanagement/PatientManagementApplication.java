package com.example.Patientmanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title = "Patient Appointment Management API Documentation",
				description = "Patient Appointment Management API Documentation",
				version = "v1.0"
		)
)
public class PatientManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientManagementApplication.class, args);
	}

}

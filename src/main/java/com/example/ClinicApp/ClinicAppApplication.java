package com.example.ClinicApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.example.ClinicApp")
//@OpenAPIDefinition(info = @Info(title = "Clinic App APIS",version = "1.0",description = "Appoinment Management Apis."))
public class ClinicAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicAppApplication.class, args);
	}



}


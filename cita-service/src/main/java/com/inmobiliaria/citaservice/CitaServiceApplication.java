package com.inmobiliaria.citaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CitaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitaServiceApplication.class, args);
	}

}

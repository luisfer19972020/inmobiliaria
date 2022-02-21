package com.inmobiliaria.propiedadservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class PropiedadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropiedadServiceApplication.class, args);
	}

}

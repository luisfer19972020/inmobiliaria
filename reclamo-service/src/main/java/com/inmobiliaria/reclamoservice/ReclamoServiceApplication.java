package com.inmobiliaria.reclamoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReclamoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclamoServiceApplication.class, args);
	}

}

package com.inmobiliaria.administracionservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced//Gestiona las instancias del servicio en eureka esto para que haya multiples servidores apoyando un servicio
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

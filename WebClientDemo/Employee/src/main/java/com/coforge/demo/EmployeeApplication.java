package com.coforge.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EmployeeApplication {

	//this should be in Conifgrarion file
	@Bean
	public WebClient.Builder getwebclientbuilder(){
		return WebClient.builder().baseUrl("http://localhost:8081");
	}
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}

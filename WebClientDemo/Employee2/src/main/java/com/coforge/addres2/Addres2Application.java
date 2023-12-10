package com.coforge.addres2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Addres2Application {

	public static void main(String[] args) {
		SpringApplication.run(Addres2Application.class, args);
	}

}

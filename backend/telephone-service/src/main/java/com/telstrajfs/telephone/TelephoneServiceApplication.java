package com.telstrajfs.telephone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TelephoneServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelephoneServiceApplication.class, args);
	}

}

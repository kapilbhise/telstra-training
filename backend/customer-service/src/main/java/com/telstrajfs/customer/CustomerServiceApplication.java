package com.telstrajfs.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.common.net.HttpHeaders;



@SpringBootApplication
@EnableEurekaClient
public class CustomerServiceApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	
	@Bean
	@LoadBalanced
	public WebClient getWebClient(WebClient.Builder webClientBuilder) {
		String url="http://localhost:8200/telephone";
		return webClientBuilder.baseUrl(url)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
		
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}

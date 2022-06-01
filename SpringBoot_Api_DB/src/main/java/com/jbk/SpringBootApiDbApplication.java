package com.jbk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootApiDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiDbApplication.class, args);
	}
	
	

	@Bean
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
		
	}

}

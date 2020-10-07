package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class BookStoreUserManagement1Application {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreUserManagement1Application.class, args);
	}
	@Bean
    public RestTemplate getTemplate() {
    	return new RestTemplate();
    }


}

package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookStoreAdminLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreAdminLoginApplication.class, args);
	}

}

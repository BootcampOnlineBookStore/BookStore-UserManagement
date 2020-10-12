package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * Class: BookStoreAdminLoginApplication
 * Description: The main class which is essential for utilizing the benefits of spring boot
 * @author SAISHIVA
 * CreatedOn:2020-10-07
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BookStoreAdminLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreAdminLoginApplication.class, args);
	}

}

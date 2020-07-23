package com.onDemandCarWash.washerManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WasherManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WasherManagementApplication.class, args);
	}

}

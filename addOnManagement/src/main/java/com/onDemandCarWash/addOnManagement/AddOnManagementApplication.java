package com.onDemandCarWash.addOnManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AddOnManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddOnManagementApplication.class, args);
	}

}

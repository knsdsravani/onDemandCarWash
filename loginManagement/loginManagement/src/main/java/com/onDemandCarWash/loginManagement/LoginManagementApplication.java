package com.onDemandCarWash.loginManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoginManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginManagementApplication.class, args);
	}

}

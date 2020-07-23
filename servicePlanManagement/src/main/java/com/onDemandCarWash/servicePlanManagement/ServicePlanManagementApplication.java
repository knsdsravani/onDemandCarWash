package com.onDemandCarWash.servicePlanManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicePlanManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePlanManagementApplication.class, args);
	}

}

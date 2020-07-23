package com.onDemandCarWash.servicePlanManagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="Serviceplans")
public class ServicePlan {


	@Id
	private String packageId;
	private String serviceName;
	private String description;
	private String status;
}

package com.onDemandCarWash.carManagement.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="car")
public class Car {
	
	@Id
	private String carNumber;
	private String customerId;
	private String color;
	private String carModel;
	private Binary image;

}

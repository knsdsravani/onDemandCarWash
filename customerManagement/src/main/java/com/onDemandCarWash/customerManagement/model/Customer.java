package com.onDemandCarWash.customerManagement.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="Customer")
public class Customer {

	@Id 
	private String cId;
	private String name;
	private String email;
	private String status;
	private List<Review> review;
}

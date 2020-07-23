package com.onDemandCarWash.addOnManagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="AddOns")
public class AddOns {
	
	@Id
	private String name;
	private long cost;
	private String status;

}

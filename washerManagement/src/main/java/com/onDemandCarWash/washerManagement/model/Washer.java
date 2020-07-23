package com.onDemandCarWash.washerManagement.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="Washer")
public class Washer {

		@Id
		private String wId;
		private String name;
		private String status;
		private List<Review> reviews;
}

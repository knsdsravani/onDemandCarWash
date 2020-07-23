package com.onDemandCarWash.reportManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Washer {

	private Integer wId;
	private String name;
	private String status;
	private float ratings;
	private String reviews;
}

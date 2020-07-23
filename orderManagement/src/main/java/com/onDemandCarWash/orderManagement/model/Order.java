package com.onDemandCarWash.orderManagement.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="Order")
public class Order {

	@Id
	private String orderId;
	private String customerId;
	private String carNumber;
	private String status;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date scheduledDate;
	private String washerId;
}

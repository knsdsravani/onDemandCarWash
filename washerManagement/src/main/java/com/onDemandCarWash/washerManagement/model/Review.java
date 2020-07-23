package com.onDemandCarWash.washerManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Review {

	    private String userName;
	    private int rating;
	    private boolean approved;

	    protected Review() {
	    }
}

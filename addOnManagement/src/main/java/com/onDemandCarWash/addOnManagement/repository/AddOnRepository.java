package com.onDemandCarWash.addOnManagement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onDemandCarWash.addOnManagement.model.AddOns;

@Repository
public interface AddOnRepository extends MongoRepository<AddOns, String>{

	List<AddOns> findBystatus(String status);

}

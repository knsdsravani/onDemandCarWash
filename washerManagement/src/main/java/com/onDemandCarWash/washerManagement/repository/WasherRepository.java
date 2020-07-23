package com.onDemandCarWash.washerManagement.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onDemandCarWash.washerManagement.model.Washer;

@Repository
public interface WasherRepository extends MongoRepository<Washer, Integer>{
	List<Washer> findByStatus(String status);
}

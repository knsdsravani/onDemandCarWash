package com.onDemandCarWash.carManagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onDemandCarWash.carManagement.model.Car;

@Repository
public interface CarRepository extends MongoRepository<Car, String>{

}

package com.onDemandCarWash.customerManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onDemandCarWash.customerManagement.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {

	List<Customer> findByStatus(String status);

	Optional<Customer> findByCId(String id);

}

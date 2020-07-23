package com.onDemandCarWash.orderManagement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onDemandCarWash.orderManagement.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

	List<Order> findByStatus(String status);

	List<Order> findByWasherId(Integer wId);

	List<Order> findByCustomerId(Integer custId);

}

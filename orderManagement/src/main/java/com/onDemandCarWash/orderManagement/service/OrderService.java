package com.onDemandCarWash.orderManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onDemandCarWash.orderManagement.exception.OrderNotFoundException;
import com.onDemandCarWash.orderManagement.model.Order;
import com.onDemandCarWash.orderManagement.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;

	public Order createOrder(Order order) {
		return orderRepo.insert(order);
	}

	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	public List<Order> getAllOrdersByStatus(String status) {
		List<Order> orders = orderRepo.findByStatus(status);
		if(orders.isEmpty())
			throw new OrderNotFoundException("There is no order Present with the status "+ status);
		return orders;
	}

	public Order updateOrder(Order order) {
		return orderRepo.save(order);
	}

	public List<Order> getAllOrdersWasherId(Integer wId) {
		List<Order> orders = orderRepo.findByWasherId(wId);
		if(orders.isEmpty())
			throw new OrderNotFoundException("There is no order Present with Washer ID "+ wId);
		return orders;
	}

	public List<Order> getAllOrdersCustomerId(Integer custId) {
		List<Order> orders = orderRepo.findByCustomerId(custId);
		if(orders.isEmpty())
			throw new OrderNotFoundException("There is no order Present with Customer ID "+ custId);
		return orders;
	}
	
	

}
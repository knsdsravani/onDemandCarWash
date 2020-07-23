package com.onDemandCarWash.orderManagement.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.onDemandCarWash.orderManagement.model.Order;
import com.onDemandCarWash.orderManagement.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeAnOrder")
	public ResponseEntity<Object> addNewOrder(@RequestBody Order order){	
		Order savedOrder = orderService.createOrder(order);
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}").buildAndExpand(savedOrder.getOrderId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	@GetMapping("/getAllOrders/{status}")
	public List<Order> getOrdersByStatus(@PathVariable String status) {
		return orderService.getAllOrdersByStatus(status);
	}
	
	@GetMapping("/getOrdersOfWasher/{wId}")
	public List<Order> getOrdersByWasherId(@PathVariable Integer wId){
		return orderService.getAllOrdersWasherId(wId);
	}
	
	@GetMapping("/getOrdersOfCustomer/{custId}")
	public List<Order> getOrdersByCustomerId(@PathVariable Integer custId){
		return orderService.getAllOrdersCustomerId(custId);
	}
	
	@PostMapping("/updateOrder")
	public Order updateOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}
	
}

package com.onDemandCarWash.customerManagement.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.onDemandCarWash.customerManagement.model.Customer;
import com.onDemandCarWash.customerManagement.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/createCustomer")
	public ResponseEntity<Object> addNewCustomer(@RequestBody Customer customer){	
		Customer savedCustomer = customerService.createNewCustomer(customer);
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}").buildAndExpand(savedCustomer.getCId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomerById(@PathVariable String id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/getAllCustomers/{status}")
	public List<Customer> getCustomersByStatus(@PathVariable String status) {
		return customerService.getAllCustomersByStatus(status);
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeCustomerById(@PathVariable String id) {
		customerService.deleteCustomerById(id);
	}
	
	@PostMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/deleteAllCustomers")
	public String deleteAllCustomers() {
		return customerService.deleteAllCustomers();
	}
	
}

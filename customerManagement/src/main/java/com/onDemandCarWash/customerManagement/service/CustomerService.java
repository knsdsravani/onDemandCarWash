package com.onDemandCarWash.customerManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onDemandCarWash.customerManagement.exception.CustomerNotFoundException;
import com.onDemandCarWash.customerManagement.model.Customer;
import com.onDemandCarWash.customerManagement.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	
	public Customer createNewCustomer(Customer customer) {
		return customerRepo.insert(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	public Customer getCustomerById(String id){
		Optional<Customer> customer = customerRepo.findByCId(id);
		if(!customer.isPresent()) 
			throw new CustomerNotFoundException("Customer Not found with the ID " + id);
		return customer.get();	
	}

	public List<Customer> getAllCustomersByStatus(String status) {
		List<Customer> customers = customerRepo.findByStatus(status);
		if(customers.isEmpty())
			throw new CustomerNotFoundException("There is no customer present with status " + status);
		return customers;
	}

	public void deleteCustomerById(String id) {
		Optional<Customer> customer = customerRepo.findByCId(id);
		if(!customer.isPresent()) 
			throw new CustomerNotFoundException("Customer Not found with the ID " + id);
		customerRepo.delete(customer.get());;
	}

	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public String deleteAllCustomers() {
		customerRepo.deleteAll();
		return "CustomersData removed successfully!!!";
	}
}

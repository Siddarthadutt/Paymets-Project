package com.project.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.payments.model.Customer;
import com.project.payments.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@PostMapping("/add-customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/get-customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(name = "id") long customerId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Customer is available.");
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
	} 
	
	@GetMapping("/get-allCustomers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
}

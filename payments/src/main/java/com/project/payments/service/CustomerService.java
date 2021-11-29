package com.project.payments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payments.exception.CustomerNotFoundException;
import com.project.payments.model.Customer;
import com.project.payments.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer getCustomerById(long customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if(customer.isPresent()) {
			return customer.get();
		}
		throw new CustomerNotFoundException("This customer does not exist");
	}

	public void updateBalanceById(long customerId, double balance) {
		// TODO Auto-generated method stub
		customerRepository.updateBalanceById(customerId,balance);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
	
	
}

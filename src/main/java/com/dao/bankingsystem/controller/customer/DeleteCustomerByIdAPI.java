package com.dao.bankingsystem.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.Customer;
import com.dao.bankingsystem.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customer")
public class DeleteCustomerByIdAPI {
	@Autowired
	protected CustomerRepository customerRepository;
	
	@DeleteMapping("/remove-by-id")
	public Customer deleteCustomerById(@RequestParam String id) {
		
		Customer customer = customerRepository.findById(id).orElse(null);
		
		if (customer != null) {
			customerRepository.deleteById(id);
		}
		
		return customer;
	}
}

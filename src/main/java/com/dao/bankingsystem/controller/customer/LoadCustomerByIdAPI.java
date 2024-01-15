package com.dao.bankingsystem.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.Customer;
import com.dao.bankingsystem.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customer")
public class LoadCustomerByIdAPI {
	@Autowired
	protected CustomerRepository customerRepository;
	
	@GetMapping("/by-id")
	public Customer loadCustomerById(@RequestParam String id) {
		return customerRepository.findById(id).orElse(null);
	}
}

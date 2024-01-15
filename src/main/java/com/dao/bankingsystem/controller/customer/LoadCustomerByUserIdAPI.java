package com.dao.bankingsystem.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.Customer;
import com.dao.bankingsystem.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customer/search")
public class LoadCustomerByUserIdAPI {
	@Autowired
	protected CustomerRepository customerRepository;
	
	@GetMapping("/by-userid")
	public Customer loadCustomerByUserId(@RequestParam String userId) {
		return customerRepository.findByUserId(userId);
	}
}

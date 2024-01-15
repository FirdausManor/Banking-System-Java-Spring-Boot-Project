package com.dao.bankingsystem.controller.customer;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.Customer;
import com.dao.bankingsystem.repository.CustomerRepository;
import com.dao.bankingsystem.service.customer.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CreateCustomerAPI {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected CustomerService customerService;
	
	@PostMapping("/create")
	public Customer createCustomer(@RequestBody Customer customer) {
		logger.info("### {}.createCustomer ###", getClass().getSimpleName());
		
		return null; 
	}
}

package com.dao.bankingsystem.controller.customer_account;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.CustomerAccount;
import com.dao.bankingsystem.repository.CustomerAccountRepository;

@RestController
@RequestMapping("/api/customer-account")
public class CreateCustomerAccountAPI {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected CustomerAccountRepository customerAccountRepository;
	
	@PostMapping("/add")
	public CustomerAccount createCustomerAccount(@RequestBody CustomerAccount customerAccount) {
		logger.info("### {}.createCustomerAccount ", getClass().getSimpleName());
		
		return customerAccountRepository.save(customerAccount); 
	}
}

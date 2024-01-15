package com.dao.bankingsystem.controller.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.service.customer.dto.RegisterCusotmerRequest;
import com.dao.bankingsystem.service.customer.CustomerService;
import com.dao.bankingsystem.service.customer.dto.RegisterCustomerResponse;

@RestController
@RequestMapping("/api/customer")
public class RegisterCustomerAPI {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired 
	protected CustomerService customerService;
	
	@PostMapping("/register")
	public RegisterCustomerResponse registerCustomer(@RequestBody RegisterCusotmerRequest registerCustomerRequest) {
		logger.info("### {}.registerCustomer ###", getClass().getSimpleName());
		logger.info("### registerCustomerRequest => {} ###", registerCustomerRequest);
		
		return customerService.registerCustomer(registerCustomerRequest);
	}
	
}

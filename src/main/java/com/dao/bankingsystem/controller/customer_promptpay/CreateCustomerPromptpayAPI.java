package com.dao.bankingsystem.controller.customer_promptpay;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.CustomerPromptpay;
import com.dao.bankingsystem.repository.CustomerPromptpayRepository;

@RestController
@RequestMapping("/api/customer-promptpay")
public class CreateCustomerPromptpayAPI {
	@Autowired
	protected CustomerPromptpayRepository customerPromptpayRepository;

	@PostMapping("/create")
	public CustomerPromptpay createCustomerPromptpay(@RequestBody CustomerPromptpay customerPromptpay) {
		customerPromptpay.setId(UUID.randomUUID().toString());
		return customerPromptpayRepository.save(customerPromptpay); 
	}
}

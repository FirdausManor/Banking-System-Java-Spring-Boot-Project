package com.dao.bankingsystem.controller.customer_promptpay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.CustomerPromptpay;
import com.dao.bankingsystem.repository.CustomerPromptpayRepository;

@RestController
@RequestMapping("/api/customer-promptpay")
public class LoadCustomerPromptpayAllAPI {
	@Autowired
	protected CustomerPromptpayRepository customerPromptpayRepository;
	
	@GetMapping("/search-all")
	public List<CustomerPromptpay> loadAllCustomerPromptpays( ) {
		return customerPromptpayRepository.findAll();
	}
}

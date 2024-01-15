package com.dao.bankingsystem.controller.customer_promptpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.CustomerPromptpay;
import com.dao.bankingsystem.repository.CustomerPromptpayRepository;

@RestController
@RequestMapping("/api/customer-promptpay")
public class LoadCustomerPromptpayByIdAPI {
	@Autowired
	protected CustomerPromptpayRepository customerPromptpayRepository;
	
	@GetMapping("/search-by-id")
	public CustomerPromptpay loadCustomerPromptpayById(@RequestParam String id) {
		return customerPromptpayRepository.findById(id).orElse(null);
	}
}

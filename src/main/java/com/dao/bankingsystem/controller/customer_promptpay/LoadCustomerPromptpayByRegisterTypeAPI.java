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
public class LoadCustomerPromptpayByRegisterTypeAPI {
	@Autowired
	protected CustomerPromptpayRepository customerPromptpayRepository;
	
	@GetMapping("/search-by-Register-type")
	public CustomerPromptpay loadCustomerPromptpayByRegisterType(@RequestParam String registerType) {
		return customerPromptpayRepository.findByRegisterType(registerType);
	}
}

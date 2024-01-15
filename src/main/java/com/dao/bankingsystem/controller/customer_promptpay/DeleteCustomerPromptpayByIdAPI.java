package com.dao.bankingsystem.controller.customer_promptpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.CustomerPromptpay;
import com.dao.bankingsystem.repository.CustomerPromptpayRepository;

@RestController
@RequestMapping("/api/customer-promptpay")
public class DeleteCustomerPromptpayByIdAPI {
	@Autowired
	protected CustomerPromptpayRepository customerPromptpayRepository;
	
	@DeleteMapping("/remove-by-id")
	public CustomerPromptpay deleteCustomerPromptpayById(@RequestParam String id) {
		
		CustomerPromptpay customerPromptpay = customerPromptpayRepository.findById(id).orElse(null);
		
		if (customerPromptpay != null) {
			customerPromptpayRepository.deleteById(id);
		}
		
		return customerPromptpay;
	}
}

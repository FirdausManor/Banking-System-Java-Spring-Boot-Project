package com.dao.bankingsystem.controller.customer_promptpay;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.CustomerPromptpay;
import com.dao.bankingsystem.repository.CustomerPromptpayRepository;

@RestController
@RequestMapping("/api/customer-promptpay")
public class UpdateCustomerPromptpayAPI {
	@Autowired
	protected CustomerPromptpayRepository customerPromptpayRepository;
	
	@PutMapping("/update")
	public CustomerPromptpay updateCustomerPromptpay(@RequestBody CustomerPromptpay customerPromptpay) {
		customerPromptpay.setLastModifiedAt(new Date());
		return customerPromptpayRepository.save(customerPromptpay);
	}
}

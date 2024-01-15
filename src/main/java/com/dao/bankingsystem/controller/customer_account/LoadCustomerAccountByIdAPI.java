package com.dao.bankingsystem.controller.customer_account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.CustomerAccount;
import com.dao.bankingsystem.repository.CustomerAccountRepository;

@RestController
@RequestMapping("/api/customer-account")
public class LoadCustomerAccountByIdAPI {
	@Autowired
	protected CustomerAccountRepository customerAccountRepository;
	
	@GetMapping("/by-id")
	public CustomerAccount loadCustomerAccountById(@RequestParam String id) {
		return customerAccountRepository.findById(id).orElse(null);
	}
}

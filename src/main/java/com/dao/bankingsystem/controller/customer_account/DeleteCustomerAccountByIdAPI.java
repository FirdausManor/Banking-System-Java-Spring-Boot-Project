package com.dao.bankingsystem.controller.customer_account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.CustomerAccount;
import com.dao.bankingsystem.repository.CustomerAccountRepository;

@RestController
@RequestMapping("/api/customer-account")
public class DeleteCustomerAccountByIdAPI {
	@Autowired
	protected CustomerAccountRepository customerAccountRepository;
	
	@DeleteMapping("/remove-by-id")
	public CustomerAccount deleteById(@RequestParam String id) {
		
		CustomerAccount customerAccount = customerAccountRepository.findById(id).orElse(null);
		
		if (customerAccount != null) {
			customerAccountRepository.deleteById(id);
		}
		
		return customerAccount;
	}
}

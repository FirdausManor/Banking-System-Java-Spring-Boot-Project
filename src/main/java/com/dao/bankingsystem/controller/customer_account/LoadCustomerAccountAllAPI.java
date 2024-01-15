package com.dao.bankingsystem.controller.customer_account;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.CustomerAccount;
import com.dao.bankingsystem.repository.CustomerAccountRepository;

@RestController
@RequestMapping("/api/customer-account")
public class LoadCustomerAccountAllAPI {
	@Autowired
	protected CustomerAccountRepository customerAccountRepository;
	
	@GetMapping("/all-customer-account")
	public List<CustomerAccount> loadAllCustomerAccount( ) {
		return customerAccountRepository.findAll();
	}
}

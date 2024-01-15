package com.dao.bankingsystem.controller.customer_account;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.CustomerAccount;
import com.dao.bankingsystem.repository.CustomerAccountRepository;

@RestController
@RequestMapping("/api/customer-account")
public class UpdateCustomerAccountAPI {
	@Autowired
	protected CustomerAccountRepository customerAccountRepository;
	
	@PutMapping("/update-customer-account")
	public CustomerAccount updateCustomerAccount(@RequestBody CustomerAccount customerAccount) {
		customerAccount.setLastModifiedAt(new Date());
		return customerAccountRepository.save(customerAccount);
	}
}

package com.dao.bankingsystem.controller.customer;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.Customer;
import com.dao.bankingsystem.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customer")
public class UpdateCustomerAPI {
	@Autowired
	protected CustomerRepository customerRepository;
	
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customer.setLastModifiedAt(new Date());
		return customerRepository.save(customer);
	}
}

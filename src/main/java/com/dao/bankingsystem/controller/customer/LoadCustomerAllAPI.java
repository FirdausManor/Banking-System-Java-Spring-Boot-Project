package com.dao.bankingsystem.controller.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.Customer;
import com.dao.bankingsystem.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customer/")
public class LoadCustomerAllAPI {
	@Autowired
	protected CustomerRepository customerRepository;
	
	@GetMapping("/search-all")
	public List<Customer> loadAllCustomer( ) {
		return customerRepository.findAll();
	}
}

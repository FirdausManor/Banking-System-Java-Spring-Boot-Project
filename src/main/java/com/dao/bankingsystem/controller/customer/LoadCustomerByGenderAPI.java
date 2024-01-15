package com.dao.bankingsystem.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.bankingsystem.constant.Gender;
import com.dao.bankingsystem.entity.Customer;
import com.dao.bankingsystem.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customer")
public class LoadCustomerByGenderAPI {
	@Autowired
	protected CustomerRepository customerRepository;
	
	@GetMapping("/search-by-gender")
	public List<Customer> loadCustomerByGender(@RequestParam Gender gender) {
		return customerRepository.findByGender(gender);
	}
}

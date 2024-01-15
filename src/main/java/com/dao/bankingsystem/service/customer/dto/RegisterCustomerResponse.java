package com.dao.bankingsystem.service.customer.dto;

import com.dao.bankingsystem.entity.Customer;
import com.dao.bankingsystem.entity.User;

import lombok.Data;

@Data
public class RegisterCustomerResponse {
	protected User user;
	protected Customer customer;
}

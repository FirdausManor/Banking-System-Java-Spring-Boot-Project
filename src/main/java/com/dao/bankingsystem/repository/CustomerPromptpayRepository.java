package com.dao.bankingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dao.bankingsystem.constant.StatusCode;
import com.dao.bankingsystem.entity.CustomerPromptpay;

@Repository
public interface CustomerPromptpayRepository extends JpaRepository<CustomerPromptpay, String> {
	CustomerPromptpay findByRegisterType(String register_type);
	
	CustomerPromptpay findByCustomerId(String customerId);
	
	List<CustomerPromptpay> findByStatus(StatusCode status);
}

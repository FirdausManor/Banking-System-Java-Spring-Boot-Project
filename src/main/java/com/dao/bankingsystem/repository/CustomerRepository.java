package com.dao.bankingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dao.bankingsystem.constant.Gender;
import com.dao.bankingsystem.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	Customer findByUserId(String userId);
	
	List<Customer> findByGender(Gender gender);
	
	Customer findByIdCardNo(String idCardNo);
}

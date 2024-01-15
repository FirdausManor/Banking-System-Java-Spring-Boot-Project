package com.dao.bankingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dao.bankingsystem.constant.StatusCode;
import com.dao.bankingsystem.entity.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, String> {
	AccountType findByCode(String code);
	
	AccountType findByName(String name);
	
	List<AccountType> findByStatus(StatusCode status);
}

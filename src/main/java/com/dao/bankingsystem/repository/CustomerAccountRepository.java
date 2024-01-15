package com.dao.bankingsystem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dao.bankingsystem.constant.StatusCode;
import com.dao.bankingsystem.entity.CustomerAccount;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, String> {
	List<CustomerAccount> findByStatus(StatusCode status);
	
	CustomerAccount findByAccountNo(String accountNo);
	
	List<CustomerAccount> findByAccountName(String accountName);
	
	
	//List<CustomerAccount> findAllActiveByCustomerId(String customerId);
}

package com.dao.bankingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dao.bankingsystem.entity.DepositRecord;

@Repository
public interface DepositRecordRepository extends JpaRepository<DepositRecord, String> {
	DepositRecord findByAccountNo(String accountNo);
	
	DepositRecord findByTransactionNo(String transactionNo);
}

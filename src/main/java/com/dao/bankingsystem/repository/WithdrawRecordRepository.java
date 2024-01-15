package com.dao.bankingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dao.bankingsystem.entity.WithdrawRecord;

@Repository
public interface WithdrawRecordRepository extends JpaRepository<WithdrawRecord, String> {
	WithdrawRecord findByTransactionNo(String transactionNo);
	
	WithdrawRecord findByAccountNo(String accountNo);
}

package com.dao.bankingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dao.bankingsystem.entity.TransferRecord;

@Repository
public interface TransferRecordRepository extends JpaRepository<TransferRecord, String> {
	TransferRecord findByTransactionNo(String transactionNo);
	
	TransferRecord findByFromAccountNo(String fromAccountNo);
	
	TransferRecord findByToAccountNo(String toAccountNo);
}

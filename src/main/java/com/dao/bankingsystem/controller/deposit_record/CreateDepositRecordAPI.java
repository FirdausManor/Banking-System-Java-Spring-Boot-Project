package com.dao.bankingsystem.controller.deposit_record;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.DepositRecord;
import com.dao.bankingsystem.repository.DepositRecordRepository;

@RestController
@RequestMapping("/api/deposit-record")
public class CreateDepositRecordAPI {
	@Autowired
	protected DepositRecordRepository depositRecordRepository;
	
	@PostMapping("/create")
	public DepositRecord createCustomerPromptpay(@RequestBody DepositRecord depositRecord) {
		depositRecord.setId(UUID.randomUUID().toString());
		return depositRecordRepository.save(depositRecord); 
	}
}

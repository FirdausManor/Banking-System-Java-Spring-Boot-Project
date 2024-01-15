package com.dao.bankingsystem.service.cdm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.bankingsystem.entity.CustomerAccount;
import com.dao.bankingsystem.entity.DepositRecord;
import com.dao.bankingsystem.repository.CustomerAccountRepository;
import com.dao.bankingsystem.repository.DepositRecordRepository;
import com.dao.bankingsystem.SesseionContext;
import com.dao.bankingsystem.constant.DepositChannel;

@Transactional
public class CDMService {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected DepositRecordRepository depositRecordRepository;
	
	@Autowired
	protected CustomerAccountRepository customerAccountRepository;
	
	public DepositRecord deposit(CustomerAccount customerAccount, long depositAmount) throws Exception {
		return deposit(customerAccount, depositAmount, false);
	}
	
	public DepositRecord deposit(CustomerAccount customerAccount, long depositAmount, Boolean forceError) {
		logger.info("### CDMService.deposit ###");
		
		DepositRecord depositRecord = new DepositRecord();
		depositRecord.setId(UUID.randomUUID().toString());
		depositRecord.setTransactionNo(generateDepositTransactionNo(customerAccount));
		depositRecord.setDepositChannel(DepositChannel.CDM);
		depositRecord.setBranchId(customerAccount.getBranchId());
		depositRecord.setAccountNo(customerAccount.getAccountNo());
		depositRecord.setDepositAmount(BigDecimal.valueOf(depositAmount));
		depositRecord.setDepositAt(new Date());
		
		long balance = customerAccount.getBalanceAmount().longValue() + depositAmount;
		customerAccount.setBalanceAmount(BigDecimal.valueOf(balance));
		customerAccount.setLastModifiedBy(SesseionContext.getUserProfile().getId());
		customerAccount.setLastModifiedAt(new Date());
		
		logger.info("Created deposit record from customer account => {}", customerAccount);
		
		return depositRecord;
	}
	
	protected String generateDepositTransactionNo(CustomerAccount customerAccount) {
		return UUID.randomUUID().toString();
	}
}

package com.dao.bankingsystem.service.atm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.bankingsystem.SesseionContext;
import com.dao.bankingsystem.constant.TransferChannel;
import com.dao.bankingsystem.constant.TransferTypeId;
import com.dao.bankingsystem.constant.WithdrawChannel;
import com.dao.bankingsystem.entity.CustomerAccount;
import com.dao.bankingsystem.entity.TransferRecord;
import com.dao.bankingsystem.entity.WithdrawRecord;
import com.dao.bankingsystem.repository.CustomerAccountRepository;
import com.dao.bankingsystem.repository.TransferRecordRepository;
import com.dao.bankingsystem.repository.WithdrawRecordRepository;

@Transactional
public class ATMService {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected CustomerAccountRepository customerAccountRepository;
	
	@Autowired
	protected WithdrawRecordRepository withdrawRecordRepository;
	
	@Autowired
	protected TransferRecordRepository transferRecordRepository;
	
	public WithdrawRecord withdraw(CustomerAccount customerAccount, long withdrawAmount) throws Exception {
		return withdraw(customerAccount, withdrawAmount, false);
	}
	
	public WithdrawRecord withdraw(CustomerAccount customerAccount, long withdrawAmount, Boolean forceError) throws Exception {
		logger.info("### ATMService.withdraw ###");
		
		WithdrawRecord withdrawRecord = new WithdrawRecord();
		withdrawRecord.setId(UUID.randomUUID().toString());
		withdrawRecord.setTransactionNo(generateWithdrawTransactionNo(customerAccount));
		withdrawRecord.setWithdrawChannel(WithdrawChannel.ATM);
		withdrawRecord.setBranchId(customerAccount.getBranchId());
		withdrawRecord.setAccountNo(customerAccount.getAccountNo());
		withdrawRecord.setWithdrawAmount(BigDecimal.valueOf(withdrawAmount));
		withdrawRecord.setWithdrawAt(new Date());
		
		long balance = customerAccount.getBalanceAmount().longValue() - withdrawAmount;
		customerAccount.setBalanceAmount(BigDecimal.valueOf(balance));
		customerAccount.setLastModifiedBy(SesseionContext.getUserProfile().getId());
		customerAccount.setLastModifiedAt(new Date());
		
		return withdrawRecord;
	}
	
	public TransferRecord transfer(CustomerAccount fromAccount, CustomerAccount toAccount, long transferAmount) throws Exception {
		return transfer(fromAccount, toAccount, transferAmount, false);
	}
	
	public TransferRecord transfer(CustomerAccount fromAccount, CustomerAccount toAccount, long transferAmount, Boolean forceError) throws Exception {
		logger.info("### ATMService.transfer ###");
		
		TransferRecord transferRecord = new TransferRecord();
		transferRecord.setId(UUID.randomUUID().toString());
		transferRecord.setTransactionNo(generateTransferTransactionNo(fromAccount, toAccount));
		transferRecord.setTransferTypeId(TransferTypeId.account_transfer);
		transferRecord.setTransferChannel(TransferChannel.ATM);
		transferRecord.setBranchId(fromAccount.getBranchId());
		transferRecord.setFromAccountNo(fromAccount.getAccountNo());
		transferRecord.setToAccountNo(toAccount.getAccountNo());
		transferRecord.setTransferAmount(BigDecimal.valueOf(transferAmount));
		transferRecord.setTransferAt(new Date());
		transferRecord.setTransferRemark(null);
		
		long balanceFromAcc = fromAccount.getBalanceAmount().longValue() - transferAmount;
		fromAccount.setBalanceAmount(BigDecimal.valueOf(balanceFromAcc));
		fromAccount.setLastModifiedBy(SesseionContext.getUserProfile().getId());
		fromAccount.setLastModifiedAt(new Date());
		
		long balanceToAcc = toAccount.getBalanceAmount().longValue() + transferAmount;
		toAccount.setBalanceAmount(BigDecimal.valueOf(balanceToAcc));
		toAccount.setLastModifiedBy(SesseionContext.getUserProfile().getId());
		toAccount.setLastModifiedAt(new Date());
		
		return transferRecord;
	}
	
	protected String generateWithdrawTransactionNo(CustomerAccount customerAccount) {
		return UUID.randomUUID().toString();
	}
	
	protected String generateTransferTransactionNo(CustomerAccount fromAccount, CustomerAccount toAccount) {
		return UUID.randomUUID().toString();
	}
}

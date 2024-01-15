package com.dao.bankingsystem.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.dao.bankingsystem.constant.WithdrawChannel;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "t_withdraw_record")
public class WithdrawRecord {
	@Id
	@Column(name = "id")
	protected String id;
	
	@Column(name = "transaction_no")
	protected String transactionNo;
	
	@Column(name = "withdraw_channel")
	@Enumerated(EnumType.STRING)
	protected WithdrawChannel withdrawChannel;
	
	@Column(name = "branch_id")
	protected String branchId;
	
	@Column(name = "account_no")
	protected String accountNo;
	
	@Column(name = "withdraw_amount")
	protected BigDecimal withdrawAmount;
	
	@Column(name = "withdraw_at")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Bangkok")
	protected Date withdrawAt;
}

package com.dao.bankingsystem.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.dao.bankingsystem.constant.DepositChannel;
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
@Table(name = "t_deposit_record")
public class DepositRecord {
	@Id
	@Column(name = "id")
	protected String id;
	
	@Column(name = "transaction_no")
	protected String transactionNo;
	
	@Column(name = "deposit_channel")
	@Enumerated(EnumType.STRING)
	protected DepositChannel depositChannel;
	
	@Column(name = "branch_id")
	protected String branchId;
	
	@Column(name = "account_no")
	protected String accountNo;
	
	@Column(name = "deposit_amount")
	protected BigDecimal depositAmount;
	
	@Column(name = "deposit_at")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Bangkok")
	protected Date depositAt;
}

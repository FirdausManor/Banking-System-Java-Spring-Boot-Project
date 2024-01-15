package com.dao.bankingsystem.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.dao.bankingsystem.constant.TransferChannel;
import com.dao.bankingsystem.constant.TransferTypeId;
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
@Table(name = "t_transfer_record")
public class TransferRecord {
	@Id
	@Column(name = "id")
	protected String id;
	
	@Column(name = "transaction_no")
	protected String transactionNo;
	
	@Column(name = "transfer_type_id")
	@Enumerated(EnumType.STRING)
	protected TransferTypeId transferTypeId;
	
	@Column(name = "transfer_channel")
	@Enumerated(EnumType.STRING)
	protected TransferChannel transferChannel;
	
	@Column(name = "branch_id")
	protected String branchId;
	
	@Column(name = "from_account_no")
	protected String fromAccountNo;
	
	@Column(name = "to_account_no")
	protected String toAccountNo;
	
	@Column(name = "transfer_amount")
	protected BigDecimal transferAmount;
	
	@Column(name = "transfer_at")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Bangkok")
	protected Date transferAt;
	
	@Column(name = "transfer_remark")
	protected String transferRemark;
}

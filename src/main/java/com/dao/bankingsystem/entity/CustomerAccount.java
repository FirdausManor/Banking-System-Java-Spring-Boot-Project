package com.dao.bankingsystem.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.dao.bankingsystem.constant.StatusCode;
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
@Table(name = "m_customer_account")
public class CustomerAccount {
	@Id
	@Column(name = "id")
	protected String id;
	
	@Column(name = "account_no")
	protected String accountNo;
	
	@Column(name = "account_name")
	protected String accountName;
	
	@Column(name = "customer_id")
	protected String customerId;
	
	@Column(name = "branch_id")
	protected String branchId;
	
	@Column(name = "account_type_id")
	protected String accountTypeId;
	
	@Column(name = "balance_amount")
	protected BigDecimal balanceAmount;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	protected StatusCode status;
	
	@Column(name = "created_by")
	protected String createdBy;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Bangkok")
	protected Date createdAt;
	
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;
	
	@Column(name = "last_modified_at")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Bangkok")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModifiedAt;
}

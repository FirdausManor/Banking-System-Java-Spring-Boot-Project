package com.dao.bankingsystem.entity;

import java.util.Date;
import com.dao.bankingsystem.constant.RegisterType;
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
@Table(name = "m_customer_promptpay")
public class CustomerPromptpay {
	@Id
	@Column(name = "id")
	protected String id;
	
	@Column(name = "customer_id")
	protected String customerId;
	
	@Column(name = "customer_account_id")
	protected String customerAccountId;
	
	@Column(name = "register_type")
	@Enumerated(EnumType.STRING)
	protected RegisterType registerType;
	
	@Column(name = "promptpay_no")
	protected String promptpayNo;
	
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
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Bangkok")
	protected Date lastModifiedAt;
}

package com.dao.bankingsystem.entity;

import com.dao.bankingsystem.constant.StatusCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "m_account_type")
public class AccountType {
	@Id
	@Column(name = "id")
	protected String id;
	
	@Column(name = "code")
	protected String code;
	
	@Column(name = "name")
	protected String name;
	
	@Column(name = "seq_no")
	protected int seqNo;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	protected StatusCode status;
}

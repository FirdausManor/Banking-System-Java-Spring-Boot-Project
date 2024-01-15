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
@Table(name = "m_branch")
public class Branch {
	@Id
	@Column(name = "id")
	protected String id;
	
	@Column(name = "code")
	protected String code;
	
	@Column(name = "branch_type")
	protected String branchType;
	
	@Column(name = "name")
	protected String name;
	
	@Column(name = "phone_no")
	protected String phoneNo;
	
	@Column(name = "address")
	protected String address;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	protected StatusCode status;
}

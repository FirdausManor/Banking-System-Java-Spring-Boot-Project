package com.dao.bankingsystem.entity;

import java.util.Date;

import com.dao.bankingsystem.constant.StatusCode;
import com.dao.bankingsystem.constant.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "m_user")
public class User {
	@Id
	@Column(name = "id")
	protected String id;
	
	@Column(name = "username")
	protected String username;
	
	@Column(name = "password")
	@JsonIgnore
	protected String password;
	
	@Column(name = "email")
	protected String email;
	
	@Column(name = "account_name")
	protected String accountName;
	
	@Column(name = "user_type")
	@Enumerated(EnumType.STRING)
	protected UserType userType;
	
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

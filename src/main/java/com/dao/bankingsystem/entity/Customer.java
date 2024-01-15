package com.dao.bankingsystem.entity;

import java.util.Date;

import com.dao.bankingsystem.constant.Gender;
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
@Table(name = "m_customer")
public class Customer {
	@Id
	@Column(name = "id")
	protected String id;
	
	@Column(name = "user_id")
	protected String userId;
	
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	protected Gender gender;
	
	@Column(name = "first_name")
	protected String firstName;
	
	@Column(name = "last_name")
	protected String lastName;
	
	@Column(name = "birth_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	protected Date birthDate;
	
	@Column(name = "idcard_no")
	protected String idCardNo;
	
	@Column(name = "phone_no")
	protected String phoneNo;
	
	@Column(name = "email")
	protected String email;
	
	@Column(name = "registered_address")
	protected String registeredAddress;
	
	@Column(name = "current_address")
	protected String currentAddress;
	
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

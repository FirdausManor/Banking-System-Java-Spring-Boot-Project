package com.dao.bankingsystem.model;

import com.dao.bankingsystem.constant.UserType;

import lombok.Data;

@Data
public class UserProfile {
	protected String id;
	protected String username;
	protected String accountName;
	protected String email;
	protected UserType userType;
}

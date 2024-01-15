package com.dao.bankingsystem.service.auth.exception;

import com.dao.bankingsystem.constant.StatusCode;

public class UserStatusNotActiveException extends RuntimeException {
	protected final String username;

	public UserStatusNotActiveException(String username) {
		super("User [" + username + "] status not active");
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}

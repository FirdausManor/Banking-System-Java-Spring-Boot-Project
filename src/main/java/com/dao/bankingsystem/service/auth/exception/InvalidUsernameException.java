package com.dao.bankingsystem.service.auth.exception;

public class InvalidUsernameException extends RuntimeException {
	protected final String username;
	
	public InvalidUsernameException(String username) {
		super("Invalid username [" + username + "]");
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}

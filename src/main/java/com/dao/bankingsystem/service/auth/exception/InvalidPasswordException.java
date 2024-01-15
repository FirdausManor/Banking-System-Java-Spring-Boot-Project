package com.dao.bankingsystem.service.auth.exception;

public class InvalidPasswordException extends RuntimeException {
	protected final String username;
	protected final String password;
	
	public InvalidPasswordException(String username, String password) {
		super("Invalid password [" + password + "] for username [" + username + "]");
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}

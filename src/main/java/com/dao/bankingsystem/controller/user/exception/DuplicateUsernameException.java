package com.dao.bankingsystem.controller.user.exception;

public class DuplicateUsernameException extends RuntimeException {
	protected String username;
	
	public DuplicateUsernameException(String username) {
		super("Duplicate username : " + username);
		this.username = username;
	}
	
	public String getUsername() { 
		return username;
	}
}

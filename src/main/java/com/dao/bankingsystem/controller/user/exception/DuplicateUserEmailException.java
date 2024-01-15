package com.dao.bankingsystem.controller.user.exception;

public class DuplicateUserEmailException extends RuntimeException {
protected String email;
	
	public DuplicateUserEmailException(String email) {
		super("Duplicate email : " + email);
		this.email = email;
	}
	
	public String getEmail() { 
		return email;
	}
}

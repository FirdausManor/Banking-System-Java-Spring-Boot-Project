package com.dao.bankingsystem.service.customer.dto;

import java.util.Date;
import com.dao.bankingsystem.constant.Gender;
import com.dao.bankingsystem.constant.StatusCode;
import lombok.Data;

@Data
public class RegisterCusotmerRequest {
	protected UserInfo userInfo;
	protected CustomerInfo customerInfo;
	protected boolean forceError = false; //only for test
	
	@Data
	public static class UserInfo {
		protected String username;
		protected String password;
		protected String email;
		protected String accountName;
		protected StatusCode status;
	}
	
	@Data
	public static class CustomerInfo {
		protected Gender gender;
		protected String firstName;
		protected String LastName;
		protected Date birthDate;
		protected String idCardNo;
		protected String phoneNo;
		protected String email;
		protected String registeredAddress;
		protected String currentAddress;
		
	}
}

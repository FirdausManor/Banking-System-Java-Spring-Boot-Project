package com.dao.bankingsystem.service.auth.dto;

import com.dao.bankingsystem.entity.AuthSession;
import com.dao.bankingsystem.model.UserProfile;

import lombok.Data;

@Data
public class LoginResponse {
	protected UserProfile userProfile;
	protected AuthSession authSession;
}

package com.dao.bankingsystem.service.auth;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.bankingsystem.model.UserProfile;
import com.dao.bankingsystem.constant.StatusCode;
import com.dao.bankingsystem.entity.AuthSession;
import com.dao.bankingsystem.entity.User;
import com.dao.bankingsystem.repository.AuthSessionRepository;
import com.dao.bankingsystem.repository.UserRepository;
import com.dao.bankingsystem.service.auth.dto.LoginResponse;
import com.dao.bankingsystem.service.auth.exception.InvalidPasswordException;
import com.dao.bankingsystem.service.auth.exception.InvalidUsernameException;
import com.dao.bankingsystem.service.auth.exception.UserStatusNotActiveException;

@Service
public class LoginService {
	@Autowired
	protected UserRepository userRepository;
	
	@Autowired
	protected AuthSessionRepository authSessionRepository; 
	
	@Autowired
	protected PasswordEncoder passwordEncoder;
	
	@Transactional 
	public LoginResponse login(String username, String password) {
		User user = userRepository.findByUsername(username);
		
		if (user == null) {
			throw new InvalidUsernameException(username);
		}
		
		/* simple check password */
		/*
		if (!user.getPassword().equals(password)) {
			throw new InvalidPasswordException(username, password);
		}
		*/
		
		/* either check hash password or raw password */
		if (!comparePassword(password, user.getPassword())) {
			throw new InvalidPasswordException(username, password);
		}
		
		if (user.getStatus() != StatusCode.Active) {
			throw new UserStatusNotActiveException(username);
		}
		
		UserProfile userProfile = new UserProfile();
		userProfile.setId(user.getId());
		userProfile.setUsername(username);
		userProfile.setAccountName(user.getAccountName());
		userProfile.setEmail(user.getEmail()); 
		userProfile.setUserType(user.getUserType());
		
		Date now = new Date();
		
		AuthSession authSession = new AuthSession();
		authSession.setId(UUID.randomUUID().toString());
		authSession.setUserId(user.getId());
		authSession.setAccessToken(generateAccessToken(user));
		authSession.setCreatedAt(now);
		authSession.setLastAccessAt(now);
		authSession.setExpiredAt(new Date(now.getTime() + getSessionLifetimes()));
		
		authSessionRepository.save(authSession);
		
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setUserProfile(userProfile);
		loginResponse.setAuthSession(authSession);
		
		return loginResponse;
	}
	
	protected boolean comparePassword(String inputPassword, String userPassword) {
		return inputPassword.equals(userPassword) || passwordEncoder.matches(inputPassword, userPassword);
	}
	
	protected String generateAccessToken(User user) {
		return UUID.randomUUID().toString() + ":" + UUID.randomUUID().toString();
	}
	
	protected int getSessionLifetimes() {
		return 1000 * 60 * 60 * 24 * 3;
	}
}

package com.dao.bankingsystem.controller.auth;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.bankingsystem.model.UserProfile;
import com.dao.bankingsystem.service.auth.LoginService;
import com.dao.bankingsystem.service.auth.dto.LoginResponse;
import com.dao.bankingsystem.service.auth.exception.InvalidPasswordException;
import com.dao.bankingsystem.service.auth.exception.InvalidUsernameException;
import com.dao.bankingsystem.service.auth.exception.UserStatusNotActiveException;

import lombok.Data;

@RestController
@RequestMapping("/api/auth")
public class LoginAPI {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody RequestMessage requestMessage){
		logger.info("### {}.login ###", getClass().getSimpleName());
		
		LoginResponse loginResponse = loginService.login(requestMessage.getUsername(), requestMessage.getPassword());
		
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setAccessToken(loginResponse.getAuthSession().getAccessToken());
		responseMessage.setUserProfile(loginResponse.getUserProfile()); 
		
		return ResponseEntity.ok(responseMessage);
	}
	
	@ExceptionHandler(InvalidUsernameException.class)
	public ResponseEntity<?> invalidUsernameException(InvalidUsernameException ex) {
		Map<String, String> data = new LinkedHashMap<>();
		data.put("errorType", ex.getClass().getSimpleName());
		data.put("errorMessage", "Invalid username OR password");
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
		
		return responseEntity;
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<?> invalidPasswordException(InvalidPasswordException ex) {
		Map<String, String> data = new LinkedHashMap<>();
		data.put("errorType", ex.getClass().getSimpleName());
		data.put("errorMessage", "Invalid username OR password");
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
		
		return responseEntity;
	}
	
	@ExceptionHandler(UserStatusNotActiveException.class)
	public ResponseEntity<?> userStatusNotActiveException(UserStatusNotActiveException ex) {
		Map<String, String> data = new LinkedHashMap<>();
		data.put("errorType", ex.getClass().getSimpleName());
		data.put("errorMessage", "Your user account not active, Please contact admin");
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
		
		return responseEntity;
	}
	
	@Data
	public static class RequestMessage {
		protected String username;
		protected String password;
	}
	
	@Data
	public static class ResponseMessage {
		protected String accessToken;
		protected UserProfile userProfile;
	}
}

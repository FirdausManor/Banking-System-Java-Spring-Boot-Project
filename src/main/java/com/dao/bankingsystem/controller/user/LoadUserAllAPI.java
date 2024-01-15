package com.dao.bankingsystem.controller.user;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.bankingsystem.entity.AuthSession; 
import com.dao.bankingsystem.repository.AuthSessionRepository;
import com.dao.bankingsystem.repository.UserRepository;

@RestController
@RequestMapping("/api/user/")
public class LoadUserAllAPI {
	
	@Autowired
	protected UserRepository userRepository;
	
	@Autowired
	protected AuthSessionRepository authSessionRepository;
	
	@GetMapping("/load-all")
	public ResponseEntity<?> loadAllUser(@RequestHeader(name =  "x-access-token", required = false) String accessToken) {
		System.out.println("accessToken => " + accessToken);
		
		if (accessToken == null || accessToken.isBlank()) {
			Map<String, String> data = new LinkedHashMap<>();
			data.put("errorType", "AuthError");
			data.put("errorMessage", "Access Token Not Attach");
			
			ResponseEntity<?> responseEntity = new ResponseEntity<>(data, HttpStatus.UNAUTHORIZED);
			
			return responseEntity;
		}
		
		Date now = new Date();
		
		AuthSession authSession = authSessionRepository.findByAccessToken(accessToken);
		
		if (authSession == null) {
			Map<String, String> data = new LinkedHashMap<>();
			data.put("errorType", "AuthError");
			data.put("errorMessage", "Access Token Not Found");
			
			ResponseEntity<?> responseEntity = new ResponseEntity<>(data, HttpStatus.UNAUTHORIZED);
			
			return responseEntity;
		}
		
		if (now.getTime() > authSession.getExpiredAt().getTime()) {
			Map<String, String> data = new LinkedHashMap<>();
			data.put("errorType", "AuthError");
			data.put("errorMessage", "Access Token Expired");
			
			ResponseEntity<?> responseEntity = new ResponseEntity<>(data, HttpStatus.UNAUTHORIZED);
			
			return responseEntity;
		}
		
		return ResponseEntity.ok(userRepository.findAll()); 
	}
}

package com.dao.bankingsystem.service.auth;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.bankingsystem.entity.AuthSession;
import com.dao.bankingsystem.repository.AuthSessionRepository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/auth")
public class LogoutAPI {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected AuthSessionRepository authSessionRepository;
	
	@GetMapping("/logout")
	@Transactional
	public void logout(HttpServletRequest request) {
		String accessToken = request.getHeader("x-access-token");
		
		List<AuthSession> authSessions = authSessionRepository.removeByAccessToken(accessToken);
		logger.info("Remove authSession => {}", authSessions);
	}
}

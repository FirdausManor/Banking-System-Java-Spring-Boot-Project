package com.dao.bankingsystem.interceptor;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.dao.bankingsystem.entity.AuthSession;
import com.dao.bankingsystem.repository.AuthSessionRepository;
import com.dao.bankingsystem.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Order(3)
@Component
public class AuthenInterceptor extends BaseInterceptor {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected UserRepository userRepository;
	
	@Autowired
	protected AuthSessionRepository authSessionRepository;

	@Override
	protected void intercept(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		logger.info("authen request....");
		
		String accessToken = getAccessToken(request);
		
		logger.info("access token =>", accessToken);
		
		if (accessToken == null || accessToken.isBlank()) {
			Map<String, String> responseMessage = new LinkedHashMap<>();
			responseMessage.put("errorType", "AuthError");
			responseMessage.put("errorMessage", "Access Token Not Attach");
			
			replyJSON(request, response, HttpStatus.UNAUTHORIZED.value(), responseMessage);
			
			return;
		}
		
		Date now = new Date();
		
		AuthSession authSession = authSessionRepository.findByAccessToken(accessToken);
		
		if (authSession == null) {
			Map<String, String> responseMessage = new LinkedHashMap<>();
			responseMessage.put("errorType", "AuthError");
			responseMessage.put("errorMessage", "Access Token Not Found");
			
			replyJSON(request, response, HttpStatus.UNAUTHORIZED.value(), responseMessage);
			
			return;
		}
		
		if (now.getTime() > authSession.getExpiredAt().getTime()) {
			Map<String, String> responseMessage = new LinkedHashMap<>();
			responseMessage.put("errorType", "AuthError");
			responseMessage.put("errorMessage", "Access Token Expired");
			
			replyJSON(request, response, HttpStatus.UNAUTHORIZED.value(), responseMessage);
			
			return;
		}
		
		authSession.setLastAccessAt(now);
		authSession.setExpiredAt(new Date(authSession.getLastAccessAt().getTime() + getSessionLifetimes()));
		authSessionRepository.save(authSession);
		logger.info("Update AuthSession => {}", authSession);;
		
		filterChain.doFilter(request, response);
	}
	
	protected int getSessionLifetimes() {
		return 1000 * 60 * 60 * 24 * 3;
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return getIgnoreAuthenPaths(request).contains(request.getRequestURI());
	}
	
	protected List<String> getIgnoreAuthenPaths(HttpServletRequest request) {
		return List.of(
				"/api/auth/login");
	}

	protected String getAccessToken(HttpServletRequest request) {
		return request.getHeader("x-access-token");
	}
}

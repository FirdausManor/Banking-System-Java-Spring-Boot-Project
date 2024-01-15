package com.dao.bankingsystem.interceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Order(1)
@Component
public class LoggingInterceptor extends BaseInterceptor {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void intercept(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		logger.info("Incoming Request {}: {}", request.getMethod(), request.getRequestURI());
		
		filterChain.doFilter(request, response);
		
		logger.info("Completed Request {}: {}", request.getMethod(), request.getRequestURI());
	}

}

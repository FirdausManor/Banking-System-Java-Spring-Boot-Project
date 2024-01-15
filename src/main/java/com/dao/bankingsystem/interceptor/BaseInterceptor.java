package com.dao.bankingsystem.interceptor;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class BaseInterceptor extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		intercept(request, response, filterChain);
	}
	
	protected abstract void intercept(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
			throws ServletException, IOException;
	
	protected void replyJSON(HttpServletRequest request, HttpServletResponse response, int httpStatusCode, Object responseMessage) {
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(response.getWriter(), responseMessage);
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}
	
	protected String getAccessToken(HttpServletRequest request) {
		return request.getHeader("x-access-token");
	}
}

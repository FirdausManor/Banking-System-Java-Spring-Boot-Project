package com.dao.bankingsystem.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception ex, HttpServletRequest request) {
		logger.info("### GlobalExceptionHandler.ExceptionClass ###");
		
		Map<String, String> data = new LinkedHashMap<>();
		data.put("key-1", "G: value-1");
		data.put("key-2", "G: value-2");
		data.put("errorType", ex.getClass().getName());
		data.put("errorMessage", ex.getMessage());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return responseEntity;
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> exceptionHandler(HttpMessageNotReadableException ex, HttpServletRequest request) {
		logger.info("### GlobalExceptionHandler.HttpMessageNotReadableExceptionClass ###");
		
		Map<String, String> data = new LinkedHashMap<>();
		data.put("key-1", "G: value-1");
		data.put("key-2", "G: value-2");
		data.put("key-3", "G: value-3");
		data.put("key-4", "G: value-4");
		data.put("errorType", ex.getClass().getName());
		data.put("errorMessage", ex.getMessage());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
		
		return responseEntity;
	}
}

package com.dao.bankingsystem.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.model.ApplicationInfo;
import com.dao.bankingsystem.service.ApplicationInfoProvider;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/application/info")
public class ApplicationInfoAPI {

	@Autowired
	protected ApplicationInfoProvider applicationInfoProvider;
	
	@GetMapping
	public ApplicationInfo getInfoProvider(@RequestParam(required = false) boolean forceError, @RequestParam(required = false) String errorType) throws Exception {
		if (forceError) {
			if (errorType != null) {
				if (errorType.equals("1")) {
					throw new Exception("Force Exception Error");
				} else if (errorType.equals("2")) {
					throw new RuntimeException("Force RuntimeException Error");
				} else if (errorType.equals("3")) {
					throw new IllegalArgumentException("Force IllegalArgumentException Error");
				}
			} 
			throw new Exception("Force Default Error");
		}
		
		return applicationInfoProvider.getApplicationInfo();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception ex, HttpServletRequest request) {
		Map<String, String> data = new HashMap<>();
		data.put("key-1", "value-1");
		data.put("key-2", "value-2");
		data.put("errorType", ex.getClass().getName());
		data.put("errorMessage", ex.getMessage());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
		
		return responseEntity;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> exceptionHandler(RuntimeException ex, HttpServletRequest request) {
		Map<String, String> data = new HashMap<>();
		data.put("key-1", "value-1");
		data.put("key-2", "value-2");
		data.put("key-3", "value-3");
		data.put("errorType", ex.getClass().getName());
		data.put("errorMessage", ex.getMessage());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return responseEntity;
	}
}

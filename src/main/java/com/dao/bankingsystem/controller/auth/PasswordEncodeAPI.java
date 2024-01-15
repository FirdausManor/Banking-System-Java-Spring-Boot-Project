package com.dao.bankingsystem.controller.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/password-encoder")
public class PasswordEncodeAPI {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected PasswordEncoder passwordEncoder;
	
	/* hash password */
	@GetMapping("/encode")
	public String encodePassword(@RequestParam(name = "raw-password") String rawPassword) {
		logger.info("### {}.encodePassword ###", getClass().getSimpleName());
		return passwordEncoder.encode(rawPassword);
	}
	
	@GetMapping("/compare-password")
	public boolean comparePassword(@RequestParam(name = "raw-password") String rawPassword, @RequestParam(name = "encoded-password") String encodedPassword) {
		logger.info("### {}.comparePassword ###", getClass().getSimpleName());
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
}

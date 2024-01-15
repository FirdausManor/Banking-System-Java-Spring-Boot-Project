package com.dao.bankingsystem.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.User;
import com.dao.bankingsystem.repository.UserRepository;

@RestController
@RequestMapping("/api/user/search/")
public class LoadUserByIdAPI {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected UserRepository userRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> loadById(@RequestParam String id) {
		logger.info("### LoadUserByIdAPI.loadById ###");
		logger.info("id => {}", id);
		
		User user = userRepository.findById(id).orElse(null);
		
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(user);
	}
}

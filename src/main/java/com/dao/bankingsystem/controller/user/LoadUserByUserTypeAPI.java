package com.dao.bankingsystem.controller.user;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.constant.UserType;
import com.dao.bankingsystem.entity.User;
import com.dao.bankingsystem.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class LoadUserByUserTypeAPI {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected UserRepository userRepository;
	
	@GetMapping("load-by-user-type")
	public ResponseEntity<?> loadByUserType(@RequestParam String userType) {
		logger.info("### LoadUserByUserTypeAPI.loadByUserType ###");
		
		List<User> users = userRepository.findByUserType(UserType.valueOf(userType));
		
		if (users == null || users.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(users);
	}
}

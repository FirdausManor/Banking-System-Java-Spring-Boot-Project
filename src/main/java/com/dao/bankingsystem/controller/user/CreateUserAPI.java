package com.dao.bankingsystem.controller.user;

import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.User;
import com.dao.bankingsystem.service.user.UserService;

@RestController
@RequestMapping("/api/user")
public class CreateUserAPI {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected UserService userService;
	
	@PostMapping("/create-user")
	public User createUser(@RequestBody User user) {
		logger.info("### {}.createUser ###", getClass().getSimpleName());
		
		return userService.createUser(user); 
	}
}

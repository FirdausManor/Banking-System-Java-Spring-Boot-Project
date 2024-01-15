package com.dao.bankingsystem.controller.user;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.User;
import com.dao.bankingsystem.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UpdateUserAPI {
	@Autowired
	protected UserRepository userRepository;
	
	@PutMapping("/update-user")
	public User updateUser(@RequestBody User user) {
		user.setLastModifiedAt(new Date());
		return userRepository.save(user);
	}
}

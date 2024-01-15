package com.dao.bankingsystem.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.User;
import com.dao.bankingsystem.repository.UserRepository;

@RestController
@RequestMapping("/api/user/search")
public class LoadUserByUsernameAPI {
	@Autowired
	protected UserRepository userRepository;
	
	@GetMapping("/by-username")
	public User loadUsername(@RequestParam String username) {
		return userRepository.findByUsername(username);
	}
}

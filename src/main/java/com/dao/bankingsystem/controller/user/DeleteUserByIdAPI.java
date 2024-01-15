package com.dao.bankingsystem.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.User;
import com.dao.bankingsystem.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class DeleteUserByIdAPI {
	@Autowired
	protected UserRepository userRepository;
	
	@DeleteMapping("/remove-by-id")
	public User deleteById(@RequestParam String id) {
		
		User user = userRepository.findById(id).orElse(null);
		
		if (user != null) {
			userRepository.deleteById(id);
		}
		
		return user;
	}
}

package com.dao.bankingsystem.controller.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.constant.StatusCode;
import com.dao.bankingsystem.entity.User;
import com.dao.bankingsystem.repository.UserRepository;

@RestController
@RequestMapping("/api/user/search/")
public class LoadUserByStatusAPI {
	@Autowired
	protected UserRepository userRepository;
	
	@GetMapping("/by-status")
	public List<User> loadUser(@RequestParam StatusCode status) {
		return userRepository.findByStatus(status);
	}
}

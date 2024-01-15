package com.dao.bankingsystem.service.user;

import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.bankingsystem.controller.user.exception.DuplicateUserEmailException;
import com.dao.bankingsystem.controller.user.exception.DuplicateUsernameException;
import com.dao.bankingsystem.entity.User;
import com.dao.bankingsystem.repository.UserRepository;

@Service
public class UserService {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected UserRepository userRepository;
	
	@Transactional
	public User createUser(User user) {
		return createUser(user, false);
	}
	
	@Transactional
	public User createUser(User user, boolean forceError) {
		logger.info("### {}.createUser ###", getClass().getSimpleName());
		
		User existingUser = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail());
		
		if (existingUser != null) {
			if (existingUser.getUsername().equals(user.getUsername())) {
				throw new DuplicateUsernameException(user.getUsername());
			}
			
			if (existingUser.getEmail().equals(user.getEmail())) {
				throw new DuplicateUserEmailException(user.getEmail());
			}
		}
		
		user.setId(UUID.randomUUID().toString());
		user.setCreatedBy("ANONYMOUS");
		user.setCreatedAt(new Date());
		
		user = userRepository.save(user);
		logger.info("Create user => {}", user);
		
		if (1 == 1) {
			//throw new RuntimeException("Force Error");
		}
		
		return user;
	}
	
	@Transactional
	public void updateCustomer() {
		//excute cutomer update
	}
}

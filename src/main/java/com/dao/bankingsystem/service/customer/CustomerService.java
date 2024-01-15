package com.dao.bankingsystem.service.customer;

import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.bankingsystem.constant.UserType;
import com.dao.bankingsystem.entity.Customer;
import com.dao.bankingsystem.entity.User;
import com.dao.bankingsystem.repository.CustomerRepository;
import com.dao.bankingsystem.service.customer.dto.RegisterCusotmerRequest;
import com.dao.bankingsystem.service.customer.dto.RegisterCustomerResponse;
import com.dao.bankingsystem.service.customer.exception.DuplicateCustomerIdcardNoException;
import com.dao.bankingsystem.service.user.UserService;

@Service
public class CustomerService {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected CustomerRepository customerRepository;
	
	@Autowired
	protected PasswordEncoder passwordEncoder;
	
	@Transactional
	public RegisterCustomerResponse registerCustomer(RegisterCusotmerRequest registerCusotmerRequest) {
		logger.info("### {}.registerCustomer ", getClass().getSimpleName());
		
		User user = new User();
		user.setUsername(registerCusotmerRequest.getUserInfo().getUsername());
		user.setPassword(passwordEncoder.encode(registerCusotmerRequest.getUserInfo().getPassword()));
		user.setEmail(registerCusotmerRequest.getUserInfo().getEmail());
		user.setAccountName(registerCusotmerRequest.getUserInfo().getAccountName());
		user.setUserType(UserType.Customer);
		user.setStatus(registerCusotmerRequest.getUserInfo().getStatus());
		
		user = userService.createUser(user);
		
		if (customerRepository.findByIdCardNo(registerCusotmerRequest.getCustomerInfo().getIdCardNo()) != null) {
			throw new DuplicateCustomerIdcardNoException(registerCusotmerRequest.getCustomerInfo().getIdCardNo());
		}
		
		Customer customer = new Customer();
		customer.setId(UUID.randomUUID().toString());
		customer.setUserId(user.getId());
		customer.setGender(registerCusotmerRequest.getCustomerInfo().getGender());
		customer.setFirstName(registerCusotmerRequest.getCustomerInfo().getFirstName());
		customer.setLastName(registerCusotmerRequest.getCustomerInfo().getLastName());
		customer.setBirthDate(registerCusotmerRequest.getCustomerInfo().getBirthDate());
		customer.setIdCardNo(registerCusotmerRequest.getCustomerInfo().getIdCardNo());
		customer.setPhoneNo(registerCusotmerRequest.getCustomerInfo().getPhoneNo());
		customer.setEmail(user.getEmail());
		customer.setRegisteredAddress(registerCusotmerRequest.getCustomerInfo().getRegisteredAddress());
		customer.setCurrentAddress(registerCusotmerRequest.getCustomerInfo().getCurrentAddress());
		customer.setCreatedBy("ANONYMOUS");
		customer.setCreatedAt(new Date());
		
		customer = customerRepository.save(customer);
		logger.info("Create customer => {}", customer);
		
		if (registerCusotmerRequest.isForceError()) {
			throw new RuntimeException("Force Error");
		}
		
		RegisterCustomerResponse registerCustomerResponse = new RegisterCustomerResponse();
		registerCustomerResponse.setUser(user);
		registerCustomerResponse.setCustomer(customer);
		
		return registerCustomerResponse;
	}
}

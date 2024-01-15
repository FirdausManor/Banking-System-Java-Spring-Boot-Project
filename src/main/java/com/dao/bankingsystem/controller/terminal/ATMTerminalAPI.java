package com.dao.bankingsystem.controller.terminal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.bankingsystem.repository.CustomerAccountRepository;
import com.dao.bankingsystem.repository.CustomerRepository;
import com.dao.bankingsystem.repository.WithdrawRecordRepository;

import com.dao.bankingsystem.SesseionContext;
import com.dao.bankingsystem.constant.UserType;
import com.dao.bankingsystem.controller.terminal.TerminalContext;
import com.dao.bankingsystem.entity.Customer;
import com.dao.bankingsystem.entity.CustomerAccount;
import com.dao.bankingsystem.model.UserProfile;
//import com.dao.bankingsystem.service.auth.exception.InvalidPasswordException;
//import com.dao.bankingsysteme.service.auth.exception.InvalidUsernameException;
//import com.dao.bankingsystem.service.auth.exception.UserStatusNotActiveException;

@RestController
@RequestMapping("/api/atm-terminal-controller")
public class ATMTerminalAPI {
	@Autowired
	protected CustomerRepository customerRepository;
	
	@Autowired
	protected CustomerAccountRepository customerAccountRepository;
	
	@Autowired
	protected WithdrawRecordRepository withdrawRecordRepository;
	
	
}
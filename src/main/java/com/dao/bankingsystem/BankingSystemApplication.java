package com.dao.bankingsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingSystemApplication {
	
	protected static final Logger logger = LoggerFactory.getLogger(BankingSystemApplication.class);

	public static void main(String[] args) {
		logger.info("Before Srping Start Application Context");
		SpringApplication.run(BankingSystemApplication.class, args);
		logger.info("After Srping Start Application Context");
	}
}

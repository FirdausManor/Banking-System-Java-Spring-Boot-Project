package com.dao.bankingsystem.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import com.dao.bankingsystem.runner.TestRunner2;

public class BeanInitialConfig {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Bean
	public TestRunner2 testRunner2() {
		logger.info("### create testRunner2 bean ###");
		
		return new TestRunner2();
	}
}

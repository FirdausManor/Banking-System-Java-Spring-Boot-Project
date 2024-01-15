package com.dao.bankingsystem.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class TestRunner2 implements CommandLineRunner {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void run(String... args) throws Exception {
		logger.info("### TestRunner2.run ###");
	}
}

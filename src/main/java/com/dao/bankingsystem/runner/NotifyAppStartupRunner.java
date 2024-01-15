package com.dao.bankingsystem.runner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.dao.bankingsystem.service.EmailService;

@Component
@Order(3)
public class NotifyAppStartupRunner implements CommandLineRunner {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected EmailService emailService;
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("### NotifyAppStartupRunner.run ###");
		
		String targetEmail = "jaylato.test@gmail.com";
		String subject = "Banking System Backend Startup";
		String content = 
				"""
				<h2 style="color:red">Banking System Startup</h2> 
				<hr>
					<div>
						<b>startup time:</b> ${startedTime}
					</div>
				"""
				.replace("${startedTime}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date()));
		
		emailService.sendMail(List.of(targetEmail), subject, content);
	}
}

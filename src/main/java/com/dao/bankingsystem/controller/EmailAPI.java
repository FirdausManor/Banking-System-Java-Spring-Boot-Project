package com.dao.bankingsystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.dto.SendEmailRequest;
import com.dao.bankingsystem.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailAPI {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected EmailService emailService;
	
	@PostMapping("/sendmail")
	public String sendEmail(@RequestBody SendEmailRequest emailRequest) {
		logger.info("### EmailAPI.sendEmail ###");
		
		emailService.sendMail(emailRequest.getFromMail(), emailRequest.getFromName(), 
							  emailRequest.getTargetEmails(), emailRequest.getSubject(), 
							  emailRequest.getContent());
		
		return "Send email successfully";
	}
}

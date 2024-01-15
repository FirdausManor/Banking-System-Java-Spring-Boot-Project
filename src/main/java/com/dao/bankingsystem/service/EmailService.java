package com.dao.bankingsystem.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${email.smtp.defaultFromEmail}")
	protected String defaultFromEmail;
	
	@Value("${email.smtp.defaultFromName}")
	protected String defaultFromName;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(List<String> toList, String subject, String content) {
		sendMail(defaultFromEmail, defaultFromName, toList, subject, content);
	}
	
	public void sendMail(String fromMail, String fromName, List<String> toList, String subject, String content) {
		logger.debug("### EmailService.sendMail ###");
		
		if (fromMail == null) {
			fromMail = defaultFromEmail;
		}
		
		if (fromName == null) {
			fromName = defaultFromName;
		}
		
		logger.debug("fromEmail => " + fromMail);
		logger.debug("toList => " + toList);
		logger.debug("subject => " + subject);
		logger.debug("content => " + content);
		
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail, true);
			helper.setFrom(fromMail, fromName);
			for (String to : toList) {
				helper.addTo(to);
			}
			helper.setSubject(subject);
			helper.setText(content, true);
			mailSender.send(mail);
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
			throw new RuntimeException(ex);
		}
	}
}

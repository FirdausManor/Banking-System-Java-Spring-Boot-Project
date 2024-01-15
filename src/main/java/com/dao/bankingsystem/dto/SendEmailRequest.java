package com.dao.bankingsystem.dto;

import java.util.List;
import lombok.Data;

@Data
public class SendEmailRequest {
	protected String fromMail;
	protected String fromName;
	protected String subject;
	protected String content;
	protected List<String> targetEmails;
}

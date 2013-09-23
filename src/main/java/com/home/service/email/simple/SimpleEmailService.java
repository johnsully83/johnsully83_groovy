package com.home.service.email.simple;

import java.util.Collections;
import java.util.Locale;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;

import com.home.AppSettings;
import com.home.email.MailService;
import com.home.email.domain.MailInfo;
import com.home.service.email.EmailService;
import com.home.utility.Utility;

@Service("emailService")
public class SimpleEmailService implements EmailService {
	private final Logger log = Logger.getLogger(SimpleEmailService.class);
	
	private final MailService mailService;
	private final MessageSource messageSource;
	private final AppSettings appSettings;
	
	@Autowired
	public SimpleEmailService(MailService mailService, MessageSource messageSource, AppSettings appSettings) {
		super();
		this.mailService=mailService;
		this.messageSource=messageSource;
		this.appSettings=appSettings;
	}

	@Override
	public void sendThankyouEmail(String emailAddress, String name) {
		MailInfo mailInfo = new MailInfo();
		
		mailInfo.setSender(appSettings.getEmailSender());
		mailInfo.setTo(Collections.singletonList(emailAddress));
		
		String [] valuesToInject = {name};
		
		try {
			String subject = messageSource.getMessage("email.subject", valuesToInject, Locale.US);
			
			mailInfo.setSubject(Utility.nullCheck(subject));
		} catch(NoSuchMessageException e) {
			log.error("Error getting subject for email from message source", e);
			return;
		}
		
		mailInfo.setBody(getBodyFromMessageSource(valuesToInject));
		
		try {
			mailService.send(mailInfo);
		} catch (MessagingException e) {
			log.error("Error sending email to "+name+" address "+emailAddress, e);
		}
	}

	private String getBodyFromMessageSource(String[] valuesToInject) {
		String messageKeyPrefix = "email.body";
		Integer messageKeySuffix = 0;
		
		String body = "";
		
		while (true) {
			try {
				body += messageSource.getMessage(messageKeyPrefix+(++messageKeySuffix), valuesToInject, Locale.US);
			} catch(NoSuchMessageException e) {
				break;
			}
		}
		
		return body;
	}

}

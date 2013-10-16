package com.johnsully83.email;

import javax.mail.MessagingException;

import com.johnsully83.email.domain.MailInfo;

public interface MailService {

	public void send(MailInfo mail) throws MessagingException;
	
}

package com.home.email;

import javax.mail.MessagingException;

import com.home.email.domain.MailInfo;

public interface MailService {

	public void send(MailInfo mail) throws MessagingException;
	
}

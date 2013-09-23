package com.home.email.simple;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.home.email.MailService;
import com.home.email.domain.MailAttachment;
import com.home.email.domain.MailInfo;

public class SimpleMailService implements MailService {
	private String host;
	private String port;
	private String username;
	private String password;

	public void send(MailInfo mail) throws MessagingException {
		MimeMessage message = new MimeMessage(getSession());
		message.setSentDate(new Date());
		String body = mail.getBody();
		String sender = mail.getSender();
		message.addFrom(new InternetAddress[] { new InternetAddress(sender) });

		Collection<String> recipients = mail.getTo();
		Collection<String> ccRecipients = mail.getCc();
		setRecipients(message, Message.RecipientType.TO, recipients);
		setRecipients(message, Message.RecipientType.CC, ccRecipients);

		message.setSubject(mail.getSubject());

		MimeBodyPart messageBodyPart = new MimeBodyPart();

		if (mail.getMimeType() == null || mail.getMimeType().equals(MailInfo.HTML_MIME_TYPE)) {
			messageBodyPart.setText(body);
		} else {
			messageBodyPart.setContent(body, mail.getMimeType());
		}
		
		message.setHeader("Content-Type", "text/html");

		Multipart multipart = new MimeMultipart();

		MimeBodyPart messagePart = new MimeBodyPart();
		messagePart.setContent(body, "text/html; charset=UTF-8");
		multipart.addBodyPart(messagePart);

		setAttachments(multipart, mail.getAttachments());

		message.setContent(multipart);

		Transport.send(message);
	}


	private void setAttachments(Multipart multipart, Collection<MailAttachment> attachments)
			throws MessagingException {

		if (attachments == null || attachments.isEmpty())
			return;

		for(final MailAttachment attachment: attachments){

			MimeBodyPart attachmentPart = new MimeBodyPart();

			FileDataSource fileDataSource = new FileDataSource(attachment.getLocation()) {         
				@Override
				public String getContentType() {
					return attachment.getContentTypeText();
				}
			};

			attachmentPart.setDataHandler(new DataHandler(fileDataSource));
			attachmentPart.setFileName(attachment.getFileName());
			multipart.addBodyPart(attachmentPart);
		}       
	}

	private void setRecipients(Message message,  Message.RecipientType type, Collection<String> addresses) 
			throws MessagingException {

		if (addresses == null || addresses.isEmpty()) {
			return;
		}

		List<Address> recipients = new ArrayList<Address>(addresses.size());

		for(String address: addresses) {
			recipients.addAll(Arrays.asList(InternetAddress.parse(address, false)));
		}

		message.addRecipients(type, (Address [] )recipients.toArray(new Address[0]));
	}

	private Session getSession() {
		Authenticator authenticator = new Authenticator();

		Properties properties = new Properties();
		properties.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.host", getHost());
		properties.setProperty("mail.smtp.port", getPort());

		return Session.getInstance(properties, authenticator);
	}

	private class Authenticator extends javax.mail.Authenticator {
		private PasswordAuthentication authentication;

		public Authenticator() {
			String username = getUsername();
			String password = getPassword();
			authentication = new PasswordAuthentication(username, password);
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}  

}

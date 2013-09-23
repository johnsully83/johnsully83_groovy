package com.home.email.domain;

import java.io.Serializable;
import java.util.Collection;

public class MailInfo implements Serializable {
	private static final long serialVersionUID = -892137735610294884L;
	public static final String TEXT_MIME_TYPE = "text/plain";
	public static final String HTML_MIME_TYPE = "text/html; charset=UTF-8";

	private String smtpHost;
	private String subject;
	private String sender;
	private Collection<String> to;
	private Collection<String> cc;
	private Collection<String> bcc;
	private Collection<MailAttachment> attachments;

	private String mimeType;
	private String body;
	private String templateFile;
	private String replyTo;

	public MailInfo(){
		this.mimeType = HTML_MIME_TYPE;
	}
	
	public Collection<String> getBcc() {
		return bcc;
	}
	
	public String getBody() {
		return body;
	}
	
	public Collection<String> getCc() {
		return cc;
	}
	
	public String getMimeType() {
		return mimeType;
	}
	
	public String getSender() {
		return sender;
	}
	
	public String getSmtpHost() {
		return smtpHost;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public Collection<String> getTo() {
		return to;
	}
	
	public void setBcc(Collection<String> bcc) {
		this.bcc = bcc;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public void setCc(Collection<String> cc) {
		this.cc = cc;
	}
	
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setTo(Collection<String> to) {
		this.to = to;
	}
	
	public void setTemplateFile(String templateFile) {
		this.templateFile = templateFile;
	}
	
	public String getTemplateFile() {
		return templateFile;
	}
	
	public String getReplyTo() {
		return replyTo;
	}
	
	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}
	
	public Collection<MailAttachment> getAttachments() {
		return attachments;
	}
	
	public void setAttachments(Collection<MailAttachment> attachments) {
		this.attachments = attachments;
	}
	
}
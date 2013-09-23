package com.home.email.domain;

import java.io.Serializable;

public class MailAttachment implements Serializable {
	private static final long serialVersionUID = -8772176872254709056L;
	private String location;
	private String contentTypeText;
	private String fileName;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContentTypeText() {
		return contentTypeText;
	}
	public void setContentTypeText(String contentTypeText) {
		this.contentTypeText = contentTypeText;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}

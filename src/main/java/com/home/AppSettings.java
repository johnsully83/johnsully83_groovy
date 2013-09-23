package com.home;

public class AppSettings {
	private final String dateFormat;
	private final String emailSender;

	public AppSettings(String dateFormat, String emailSender) {
		super();
		this.dateFormat=dateFormat;
		this.emailSender = emailSender;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public String getEmailSender() {
		return emailSender;
	}

}

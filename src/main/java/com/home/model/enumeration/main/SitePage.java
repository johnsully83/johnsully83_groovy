package com.home.model.enumeration.main;

public enum SitePage {
	HOMEPAGE("homepage"),
	ABOUTME("aboutMe"),
	RESUME("resume"),
	GUESTBOOK("guestbook"),
	CODE("code")
	;
	
	private String viewName;
	
	private SitePage(String viewName) {
		this.viewName=viewName;
	}
	
	public String value() {
		return this.viewName;
	}
	
}

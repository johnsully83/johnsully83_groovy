package com.home.model.enumeration.main;

public enum YesNo {
	YES("Yes"),
	NO("No");
	
	private String value;
	
	private YesNo(String value) {
		this.value=value;
	}
	
	public String value() {
		return this.value;
	}

}

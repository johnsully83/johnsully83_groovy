package com.johnsully83.model.datatable.structure.enums;

public enum ShowOnForm  {

	YES(true,"showOnForm"), NO(false,"hideOnForm");

	private final boolean value;
	private final String cssClass;
	
	ShowOnForm(boolean value, String cssClass) {
		this.value = value;
		this.cssClass = cssClass;
	}

	public boolean getBooleanValue() {
		return value;
	}

	public String getCssClass() {
		return cssClass;
	}

}

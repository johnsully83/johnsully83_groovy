package com.home.model.datatable.structure.enums;

/**
 * Defines the field type, the type will generate a css class for the jsp page. 
 * 
 * The jQuery plugin Validation will use these css classes to add restrictions to what can be added to a field.
 * 
 * Both cssClass and inputType are used on the simpleDataTables.jsp page to generate the correct
 * input types when editing records as well as adding new records.
 * 
 * @author magnus.palm
 * 
 */
public enum FieldType {
	/**
	 * Will generate a date picker and guarantee valid date format
	 */
	DATE("date", "text"),

	/**
	 * Will guarantee valid email input
	 */
	EMAIL("email", "email"),
	/**
	 * First field in in MUST be an ID: the primary key of the entity. This field will be hidden in the add new form.
	 */
	ID("id", "text"),
	/**
	 * Standard text input
	 */
	TEXT("text", "text"),
	/**
	 * Any decimal number is valid.
	 */
	NUMBER("number", "anumber"),
	/**
	 * Only digits are valid (no decimals)
	 */
	DIGITS("digits", "digits"),
	/**
	 * Will guarantee a valid credit card format
	 */
	CREDITCARD("creditcard", "creditcard"),
	/**
	 * Will guarantee a valid URL format
	 */
	URL("url", "text"),
	/**
	 * Will generate a button using jquery ui button
	 */
	BUTTON("button", "button"),

	/**
	 * Will make sure the field gets set to a password field
	 */
	PASSWORD("password", "password"),

	/**
	 * Will turn the field into a select field
	 */
	SELECT("select", "select"),

	/**
	 * Other type.
	 */
	OTHER("other", "text"), 
	
	/**
	 * Generates a select input with yes/no
	 */
	YESNO("yesNo","select"),
	
	/**
	 * Generate a text area
	 */
	TEXTAREA("textarea","textarea");

	private final String cssClass;
	private final String inputType;

	FieldType(String cssClass, String inputType) {
		this.cssClass = cssClass;
		this.inputType = inputType;
	}

	public String getCssClass() {
		return cssClass;
	}

	public String getInputType() {
		return inputType;
	}

}

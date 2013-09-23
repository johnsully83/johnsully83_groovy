package com.home.exceptions;

public class SullyException extends Exception {
	private static final long serialVersionUID = -8159794001641742339L;
	
	public SullyException() {
		super();
	}
	
	public SullyException(String message) {
		super(message);
	}
	
	public SullyException(Throwable cause) {
		super(cause);
	}
	
	public SullyException(String message, Throwable cause) {
		super(message, cause);
	}

}

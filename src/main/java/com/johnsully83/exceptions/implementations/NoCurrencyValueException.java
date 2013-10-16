
package com.johnsully83.exceptions.implementations;

import org.apache.log4j.Logger;

import com.johnsully83.exceptions.SullyException;

public class NoCurrencyValueException extends SullyException {
	private static final long serialVersionUID = -5337086671533666539L;
	
	private final Logger log = Logger.getLogger(NoCurrencyValueException.class);

	public NoCurrencyValueException() {
		super();
	}

	public NoCurrencyValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoCurrencyValueException(String message) {
		super(message);
	}

	public NoCurrencyValueException(Throwable cause) {
		super(cause);
	}

	public NoCurrencyValueException(String code, String message) {
		super(message);
		log.error("OpenExchange did not have a value for the following currency code, which it did have: "+code);
	}

	public NoCurrencyValueException(String code, String message, Throwable cause) {
		super(message, cause);
		log.error("OpenExchange did not have a value for the following currency code, which it did have: "+code, cause);
	}

}

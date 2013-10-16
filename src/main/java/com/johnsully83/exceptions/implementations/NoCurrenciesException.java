package com.johnsully83.exceptions.implementations;

import com.johnsully83.exceptions.SullyException;

public class NoCurrenciesException extends SullyException {
	private static final long serialVersionUID = -1549224623581342586L;
	
	public NoCurrenciesException() {
		super();
	}
	
	public NoCurrenciesException(String message) {
		super(message);
	}
	
	public NoCurrenciesException(String fromCurrency, String toCurrency, Integer timestamp) {
		super("Could not find either "+fromCurrency+" value or "+toCurrency+" value for date "+timestamp);
	}

}

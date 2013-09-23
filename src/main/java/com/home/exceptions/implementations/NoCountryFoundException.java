package com.home.exceptions.implementations;

import org.apache.log4j.Logger;

import com.home.exceptions.SullyException;
import com.jgeoplanet.Place;

public class NoCountryFoundException extends SullyException {
	private static final long serialVersionUID = -6620843735171748808L;
	
	private final Logger log = Logger.getLogger(NoCountryFoundException.class);
	
	public NoCountryFoundException(String message) {
		super(message);
		log.error("Error querying for countries:\n"+message, this);
	}
	
	public NoCountryFoundException(String message, Place country) {
		super(message);
		log.error("The following country was found via Yahoo! API but did not exist in the cloud database: "+country.getName());
	}
	
	public NoCountryFoundException(Place country) {
		super();
		log.error("The following country was found via Yahoo! API but did not exist in the cloud database: "+country.getName());
	}
	
}

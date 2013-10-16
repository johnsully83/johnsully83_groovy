package com.johnsully83.exceptions.implementations;

import org.apache.log4j.Logger;

import com.jgeoplanet.Place;
import com.johnsully83.exceptions.SullyException;

public class NoStateFoundException extends SullyException {
	private static final long serialVersionUID = 8540722385396823166L;
	
	private final Logger log = Logger.getLogger(NoCountryFoundException.class);
	
	public NoStateFoundException(String message, Place state) {
		super(message);
		log.error("The following state was found via Yahoo! API but did not exist in the cloud database: "+state.getName());
	}
	
	public NoStateFoundException(Place state) {
		super();
		log.error("The following state was found via Yahoo! API but did not exist in the cloud database: "+state.getName());
	}

}

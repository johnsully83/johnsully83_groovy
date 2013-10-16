package com.johnsully83.model.hardcodedvalues.simple;

import com.johnsully83.model.hardcodedvalues.GeneralHardCodedValues;

public class SimpleGeneralHardCodedValues implements GeneralHardCodedValues {
	
	private final String emailSender;
	
	public SimpleGeneralHardCodedValues(String emailSender) {
		super();
		this.emailSender=emailSender;
	}

	@Override
	public String getEmailSender() {
		return emailSender;
	}

}

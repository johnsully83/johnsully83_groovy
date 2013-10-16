package com.johnsully83.service.validation.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.johnsully83.model.cloud.jpa.Guest;
import com.johnsully83.service.validation.FormValidator;

@Service("formValidator")
public class SimpleFormValidator implements FormValidator {
	
	private final Validator validator;
	
	@Autowired
	public SimpleFormValidator(Validator validator) {
		super();
		this.validator=validator;
	}

	@Override
	public boolean supports(Class<?> type) {
		return validator.supports(type) || type.equals(Guest.class);
	}

	@Override
	public void validate(Object entity, Errors errors) {
		if(!(entity instanceof Guest)) {
			validator.validate(entity, errors);
		} else {
			validator.validate(entity, errors);
		}
	}

}

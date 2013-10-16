package com.johnsully83.service.propertyEditor.field;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnsully83.AppSettings;

@Service("datePropertyEditor")
public class DatePropertyEditor extends PropertyEditorSupport {

	private final AppSettings appSettings;
	
	@Autowired
	public DatePropertyEditor(AppSettings appSettings) {
		super();
		this.appSettings=appSettings;
	}
	
	@Override
	public String getAsText() {  
		DateFormat dateFormat = new SimpleDateFormat(appSettings.getDateFormat());
		
		return dateFormat.format((Date) getValue());
	}
	
	@Override
	public void setAsText(String value) {  
		DateFormat dateFormat = new SimpleDateFormat(appSettings.getDateFormat());
		
		try {
			setValue(dateFormat.parse(value));
		} catch (ParseException e) {
			setValue("");
		}
	}
	
}

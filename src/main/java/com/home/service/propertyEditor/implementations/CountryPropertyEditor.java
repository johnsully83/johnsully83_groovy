package com.home.service.propertyEditor.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.home.controller.guestbook.GuestbookController;
import com.home.dao.implementations.SimpleJpaDao;
import com.home.model.cloud.jpa.Country;
import com.home.service.propertyEditor.DtoPropertyEditor;
import com.home.utility.Utility;

@Component("countryPropertyEditor")
public class CountryPropertyEditor extends DtoPropertyEditor<Country, Integer> {

	@Autowired
	public CountryPropertyEditor(@Qualifier("countryDao") SimpleJpaDao<Country, Integer> countryDao) {
		super(countryDao);
	}

	@Override
	protected String getDisplayValue(Country entity) {
		if(entity == null || entity.getPk() == null) {
			return GuestbookController.getUnitedStatesCountryID().toString();
		}
		
		return entity.getPk().toString().trim();
	}

	@Override
	protected Integer parsePrimaryKey(String value) {
		return Utility.forceParseInteger(value);
	}

}

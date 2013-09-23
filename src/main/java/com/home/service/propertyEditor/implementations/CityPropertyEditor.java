package com.home.service.propertyEditor.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.home.dao.implementations.SimpleJpaDao;
import com.home.model.cloud.jpa.City;
import com.home.service.propertyEditor.DtoPropertyEditor;
import com.home.utility.Utility;

@Component("cityPropertyEditor")
public class CityPropertyEditor extends DtoPropertyEditor<City, Integer> {

	@Autowired
	public CityPropertyEditor(@Qualifier("cityDao") SimpleJpaDao<City, Integer> cityDao) {
		super(cityDao);
	}

	@Override
	protected String getDisplayValue(City entity) {
		if(entity == null || entity.getPk() == null) {
			return "";
		}
		
		return entity.getPk().toString().trim();
	}

	@Override
	protected Integer parsePrimaryKey(String value) {
		return Utility.forceParseInteger(value);
	}

}

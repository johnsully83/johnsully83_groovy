package com.johnsully83.service.propertyEditor.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.johnsully83.dao.implementations.SimpleJpaDao;
import com.johnsully83.model.cloud.jpa.City;
import com.johnsully83.service.propertyEditor.DtoPropertyEditor;
import com.johnsully83.utility.Utility;

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

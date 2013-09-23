package com.home.service.propertyEditor.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.home.controller.guestbook.GuestbookController;
import com.home.dao.implementations.SimpleJpaDao;
import com.home.model.cloud.jpa.State;
import com.home.service.propertyEditor.DtoPropertyEditor;
import com.home.utility.Utility;

@Component("statePropertyEditor")
public class StatePropertyEditor extends DtoPropertyEditor<State, Integer> {

	@Autowired
	public StatePropertyEditor(@Qualifier("stateDao") SimpleJpaDao<State, Integer> stateDao) {
		super(stateDao);
	}

	@Override
	protected String getDisplayValue(State entity) {
		if(entity == null || entity.getPk() == null) {
			return GuestbookController.getMassachusettsStateID().toString();
		}
		
		return entity.getPk().toString().trim();
	}

	@Override
	protected Integer parsePrimaryKey(String value) {
		return Utility.forceParseInteger(value);
	}

}

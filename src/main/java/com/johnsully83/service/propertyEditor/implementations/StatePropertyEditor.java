package com.johnsully83.service.propertyEditor.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.johnsully83.controller.guestbook.GuestbookController;
import com.johnsully83.dao.implementations.SimpleJpaDao;
import com.johnsully83.model.cloud.jpa.State;
import com.johnsully83.service.propertyEditor.DtoPropertyEditor;
import com.johnsully83.utility.Utility;

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

package com.home.service.workflow.helper.guest;

import com.home.AppContext;
import com.home.model.cloud.jpa.Guest;
import com.home.service.model.DtoService;
import com.home.service.workflow.helper.AbstractWorkflowHelperService;

public class GuestWorkflowHelperService extends AbstractWorkflowHelperService<Guest, Integer> {

	@SuppressWarnings("unchecked")
	public GuestWorkflowHelperService() {
		super(AppContext.getApplicationContext().getBean("guestDtoService", DtoService.class));
	}
	
}

package com.johnsully83.service.workflow.helper.guest;

import com.johnsully83.AppContext;
import com.johnsully83.model.cloud.jpa.Guest;
import com.johnsully83.service.model.DtoService;
import com.johnsully83.service.workflow.helper.AbstractWorkflowHelperService;

public class GuestWorkflowHelperService extends AbstractWorkflowHelperService<Guest, Integer> {

	@SuppressWarnings("unchecked")
	public GuestWorkflowHelperService() {
		super(AppContext.getApplicationContext().getBean("guestDtoService", DtoService.class));
	}
	
}

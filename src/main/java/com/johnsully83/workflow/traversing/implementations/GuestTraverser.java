package com.johnsully83.workflow.traversing.implementations;

import com.johnsully83.model.cloud.jpa.Guest;
import com.johnsully83.service.workflow.helper.guest.GuestWorkflowHelperService;
import com.johnsully83.service.workflow.helper.guest.GuestWorkflowHelperWrapper;
import com.johnsully83.workflow.traversing.AbstractTraverser;

public class GuestTraverser extends AbstractTraverser<GuestWorkflowHelperService, GuestWorkflowHelperWrapper,
	Guest, Integer> {

	public GuestTraverser() {
		super(new GuestWorkflowHelperService(), new GuestWorkflowHelperWrapper());
	}
	
}

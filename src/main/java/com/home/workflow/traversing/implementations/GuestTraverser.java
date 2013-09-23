package com.home.workflow.traversing.implementations;

import com.home.model.cloud.jpa.Guest;
import com.home.service.workflow.helper.guest.GuestWorkflowHelperService;
import com.home.service.workflow.helper.guest.GuestWorkflowHelperWrapper;
import com.home.workflow.traversing.AbstractTraverser;

public class GuestTraverser extends AbstractTraverser<GuestWorkflowHelperService, GuestWorkflowHelperWrapper,
	Guest, Integer> {

	public GuestTraverser() {
		super(new GuestWorkflowHelperService(), new GuestWorkflowHelperWrapper());
	}
	
}

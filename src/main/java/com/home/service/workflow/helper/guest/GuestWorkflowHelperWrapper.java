package com.home.service.workflow.helper.guest;

import java.util.List;

import com.home.model.cloud.jpa.Guest;
import com.home.service.workflow.helper.AbstractWorkflowHelperWrapper;

public class GuestWorkflowHelperWrapper extends AbstractWorkflowHelperWrapper<Guest, Integer> {
	private List<Guest> allEntities;

	public GuestWorkflowHelperWrapper() {
		super();
	}

	@Override
	public List<Guest> getAllEntities() {
		return allEntities;
	}

	public void setAllEntities(List<Guest> allEntities) {
		this.allEntities = allEntities;
	}

}

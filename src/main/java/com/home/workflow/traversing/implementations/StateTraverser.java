package com.home.workflow.traversing.implementations;

import com.home.model.cloud.jpa.State;
import com.home.service.workflow.helper.state.StateWorkflowHelperService;
import com.home.service.workflow.helper.state.StateWorkflowHelperWrapper;
import com.home.workflow.traversing.AbstractTraverser;

public class StateTraverser extends AbstractTraverser<StateWorkflowHelperService, StateWorkflowHelperWrapper, State, Integer> {
	
	public StateTraverser() {
		super(new StateWorkflowHelperService(), new StateWorkflowHelperWrapper());
	}

}

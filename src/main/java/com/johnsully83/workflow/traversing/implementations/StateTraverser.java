package com.johnsully83.workflow.traversing.implementations;

import com.johnsully83.model.cloud.jpa.State;
import com.johnsully83.service.workflow.helper.state.StateWorkflowHelperService;
import com.johnsully83.service.workflow.helper.state.StateWorkflowHelperWrapper;
import com.johnsully83.workflow.traversing.AbstractTraverser;

public class StateTraverser extends AbstractTraverser<StateWorkflowHelperService, StateWorkflowHelperWrapper, State, Integer> {
	
	public StateTraverser() {
		super(new StateWorkflowHelperService(), new StateWorkflowHelperWrapper());
	}

}

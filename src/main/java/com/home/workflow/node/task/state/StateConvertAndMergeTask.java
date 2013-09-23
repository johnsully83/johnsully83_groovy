package com.home.workflow.node.task.state;

import org.apache.log4j.Logger;

import com.home.workflow.node.task.Task;
import com.home.workflow.traversing.implementations.StateTraverser;

public class StateConvertAndMergeTask extends Task<StateTraverser> {
	private final Logger log = Logger.getLogger(StateConvertAndMergeTask.class);

	@Override
	protected void handle(StateTraverser tasks) {
		try {
			tasks.getWorkflowHelperService().convertStatesAndMerge(tasks);
		} catch(Exception e) {
			log.error("Error occurred while converting states to dtos", e);
		}
	}

}

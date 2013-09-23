package com.home.workflow.node.task.state;

import org.apache.log4j.Logger;

import com.home.workflow.node.task.Task;
import com.home.workflow.traversing.implementations.StateTraverser;

public class StateReplicateToMongoTask extends Task<StateTraverser> {
	private final Logger log = Logger.getLogger(StateReplicateToMongoTask.class);
	
	@Override
	protected void handle(StateTraverser tasks) {
		try {
			tasks.getWorkflowHelperService().replicateToMongoDB(tasks);
		} catch(Exception e) {
			log.error("Error while replicating State to Mongo DB database", e);
		}
	}

}

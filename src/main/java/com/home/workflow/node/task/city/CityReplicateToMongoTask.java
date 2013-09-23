package com.home.workflow.node.task.city;

import org.apache.log4j.Logger;

import com.home.workflow.node.task.Task;
import com.home.workflow.traversing.implementations.CityTraverser;

public class CityReplicateToMongoTask extends Task<CityTraverser> {
	private final Logger log = Logger.getLogger(CityReplicateToMongoTask.class);

	@Override
	protected void handle(CityTraverser tasks) {
		try {
			tasks.getWorkflowHelperService().replicateToMongoDB(tasks);
		} catch(Exception e) {
			log.error("Error while replicating City to Mongo DB database", e);
		}
	}

}

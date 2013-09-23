package com.home.workflow.node.task.country;

import org.apache.log4j.Logger;

import com.home.workflow.node.task.Task;
import com.home.workflow.traversing.implementations.CountryTraverser;

public class CountryReplicateToMongoTask extends Task<CountryTraverser> {
	private final Logger log = Logger.getLogger(CountryReplicateToMongoTask.class);

	@Override
	protected void handle(CountryTraverser tasks) {
		try {
			tasks.getWorkflowHelperService().replicateToMongoDB(tasks);
		} catch(Exception e) {
			log.error("Error while replicating Country to Mongo DB database", e);
		}
	}

}

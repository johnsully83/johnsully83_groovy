package com.home.workflow.node.task.currency;

import org.apache.log4j.Logger;

import com.home.workflow.node.task.Task;
import com.home.workflow.traversing.implementations.CurrencyTraverser;

public class CurrencyReplicateToMongoTask extends Task<CurrencyTraverser> {
	private final Logger log = Logger.getLogger(CurrencyReplicateToMongoTask.class);

	@Override
	protected void handle(CurrencyTraverser tasks) {
		try {
			tasks.getWorkflowHelperService().replicateToMongoDB(tasks);
		} catch(Exception e) {
			log.error("Error occurred while replicating MySQL currency dtos to MongoDB", e);
		}
	}

}

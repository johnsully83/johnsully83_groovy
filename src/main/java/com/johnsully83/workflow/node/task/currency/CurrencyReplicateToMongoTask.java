package com.johnsully83.workflow.node.task.currency;

import org.apache.log4j.Logger;

import com.johnsully83.workflow.node.task.Task;
import com.johnsully83.workflow.traversing.implementations.CurrencyTraverser;

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

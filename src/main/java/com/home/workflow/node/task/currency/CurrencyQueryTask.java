package com.home.workflow.node.task.currency;

import org.apache.log4j.Logger;

import com.home.workflow.node.task.Task;
import com.home.workflow.traversing.implementations.CurrencyTraverser;

public class CurrencyQueryTask extends Task<CurrencyTraverser> {
	private final Logger log = Logger.getLogger(CurrencyQueryTask.class);

	@Override
	protected void handle(CurrencyTraverser tasks) {
		try {
			tasks.getWorkflowHelperService().queryForLatestRates(tasks);
		} catch(Exception e) {
			log.error("Error occurred while getting json dtos from open exchange", e);
		}
	}

}

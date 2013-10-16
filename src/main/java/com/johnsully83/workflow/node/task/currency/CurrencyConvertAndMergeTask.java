package com.johnsully83.workflow.node.task.currency;

import org.apache.log4j.Logger;

import com.johnsully83.workflow.node.task.Task;
import com.johnsully83.workflow.traversing.implementations.CurrencyTraverser;

public class CurrencyConvertAndMergeTask extends Task<CurrencyTraverser> {
	private final Logger log = Logger.getLogger(CurrencyConvertAndMergeTask.class);

	@Override
	public void handle(CurrencyTraverser tasks) {
		try {
			tasks.getWorkflowHelperService().convertCurrenciesAndMerge(tasks);
		} catch(Exception e) {
			log.error("Error occurred while converting and merging currency dtos", e);
		}
	}

}

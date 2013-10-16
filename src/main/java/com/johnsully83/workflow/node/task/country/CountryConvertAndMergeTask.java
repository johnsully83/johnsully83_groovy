package com.johnsully83.workflow.node.task.country;

import org.apache.log4j.Logger;

import com.johnsully83.workflow.node.task.Task;
import com.johnsully83.workflow.traversing.implementations.CountryTraverser;

public class CountryConvertAndMergeTask extends Task<CountryTraverser> {
	private final Logger log = Logger.getLogger(CountryConvertAndMergeTask.class);

	@Override
	protected void handle(CountryTraverser tasks) {
		try {
			tasks.getWorkflowHelperService().convertCountriesAndMerge(tasks);
		} catch(Exception e) {
			log.error("Error occurred during country conversion to dtos", e);
		}
		
	}

}

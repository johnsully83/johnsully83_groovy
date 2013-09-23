package com.home.workflow.node.task.country;

import org.apache.log4j.Logger;

import com.home.workflow.node.task.Task;
import com.home.workflow.traversing.implementations.CountryTraverser;

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

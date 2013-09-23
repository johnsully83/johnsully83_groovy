package com.home.workflow.node.task.city;

import org.apache.log4j.Logger;

import com.home.workflow.node.task.Task;
import com.home.workflow.traversing.implementations.CityTraverser;

public class CityConvertAndMergeTask extends Task<CityTraverser> {
	private final Logger log = Logger.getLogger(CityConvertAndMergeTask.class);

	@Override
	protected void handle(CityTraverser tasks) {
		try {
			tasks.getWorkflowHelperService().convertCitiesAndMerge(tasks);
		} catch(Exception e) {
			log.error("Error occurred during city conversion to dtos", e);
		}
	}

}

package com.home.workflow.node.task.city;

import org.apache.log4j.Logger;

import com.home.workflow.node.task.Task;
import com.home.workflow.traversing.implementations.CityTraverser;
import com.jgeoplanet.GeoPlanetException;

public class CityQueryTask extends Task<CityTraverser> {
	private final Logger log = Logger.getLogger(CityQueryTask.class);

	@Override
	protected void handle(CityTraverser tasks) {
		try {
			tasks.getWorkflowHelperService().queryForCities(tasks);
		} catch (GeoPlanetException e) {
			log.error("Yahoo GeoPlanet error occured", e);
		} catch(Exception e) {
			log.error("Exception occurred during query for cities", e);
		}
	}

}

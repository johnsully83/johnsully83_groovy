package com.johnsully83.workflow.node.task.city;

import org.apache.log4j.Logger;

import com.jgeoplanet.GeoPlanetException;
import com.johnsully83.workflow.node.task.Task;
import com.johnsully83.workflow.traversing.implementations.CityTraverser;

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

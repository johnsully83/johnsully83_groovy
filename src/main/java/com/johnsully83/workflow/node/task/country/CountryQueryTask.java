package com.johnsully83.workflow.node.task.country;

import org.apache.log4j.Logger;

import com.jgeoplanet.GeoPlanetException;
import com.johnsully83.workflow.node.task.Task;
import com.johnsully83.workflow.traversing.implementations.CountryTraverser;

public class CountryQueryTask extends Task<CountryTraverser> {
	private final Logger log = Logger.getLogger(CountryQueryTask.class);

	@Override
	protected void handle(CountryTraverser tasks) {
		try {
			tasks.getWorkflowHelperService().queryForCountries(tasks);
		} catch (GeoPlanetException e) {
			log.error("Yahoo GeoPlanet error occured", e);
		} catch(Exception e) {
			log.error("Exception occurred during query for countries", e);
		}
	}

}

package com.johnsully83.workflow.node.task.state;

import org.apache.log4j.Logger;

import com.jgeoplanet.GeoPlanetException;
import com.johnsully83.workflow.node.task.Task;
import com.johnsully83.workflow.traversing.implementations.StateTraverser;

public class StateQueryTask extends Task<StateTraverser> {
	private final Logger log = Logger.getLogger(StateQueryTask.class);
	
	@Override
	protected void handle(StateTraverser tasks) {
		try {
			tasks.getWorkflowHelperService().queryForStates(tasks);
		} catch (GeoPlanetException e) {
			log.error("Yahoo GeoPlanet error occured", e);
		} catch(Exception e) {
			log.error("Exception occurred during query for states", e);
		}
	}

}
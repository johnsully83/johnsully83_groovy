package com.home.workflow.node.task.state;

import org.apache.log4j.Logger;

import com.home.workflow.node.task.Task;
import com.home.workflow.traversing.implementations.StateTraverser;
import com.jgeoplanet.GeoPlanetException;

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
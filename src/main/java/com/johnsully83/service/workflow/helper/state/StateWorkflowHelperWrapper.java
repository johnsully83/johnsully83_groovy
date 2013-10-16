package com.johnsully83.service.workflow.helper.state;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jgeoplanet.Place;
import com.johnsully83.model.cloud.jpa.State;
import com.johnsully83.service.workflow.helper.AbstractWorkflowHelperWrapper;

public class StateWorkflowHelperWrapper extends AbstractWorkflowHelperWrapper<State, Integer> {
	private List<State> allEntities;
	private Map<Place, List<Place>> geoPlanetStates;
	
	public StateWorkflowHelperWrapper() {
		super();
		this.allEntities = new ArrayList<State>();
		this.geoPlanetStates = new LinkedHashMap<Place, List<Place>>();
	}

	@Override
	public List<State> getAllEntities() {
		return allEntities;
	}

	public void setAllEntities(List<State> allEntities) {
		this.allEntities = allEntities;
	}
	
	public Map<Place, List<Place>> getGeoPlanetStates() {
		return geoPlanetStates;
	}

	public void setGeoPlanetStates(Map<Place, List<Place>> geoPlanetStates) {
		this.geoPlanetStates = geoPlanetStates;
	}

}

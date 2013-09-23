package com.home.service.workflow.helper.country;

import java.util.ArrayList;
import java.util.List;

import com.home.model.cloud.jpa.Country;
import com.home.service.workflow.helper.AbstractWorkflowHelperWrapper;
import com.jgeoplanet.Place;

public class CountryWorkflowHelperWrapper extends AbstractWorkflowHelperWrapper<Country, Integer> {
	private List<Country> allEntities;
	private List<Place> geoPlanetCountries;

	public CountryWorkflowHelperWrapper() {
		super();
		this.allEntities = new ArrayList<Country>();
		this.geoPlanetCountries = new ArrayList<Place>();
	}

	@Override
	public List<Country> getAllEntities() {
		return allEntities;
	}

	public void setAllEntities(List<Country> allEntities) {
		this.allEntities = allEntities;
	}

	public List<Place> getGeoPlanetCountries() {
		return geoPlanetCountries;
	}

	public void setGeoPlanetCountries(List<Place> geoPlanetCountries) {
		this.geoPlanetCountries = geoPlanetCountries;
	}

}

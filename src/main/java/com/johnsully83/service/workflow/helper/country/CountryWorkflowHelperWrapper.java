package com.johnsully83.service.workflow.helper.country;

import java.util.ArrayList;
import java.util.List;

import com.jgeoplanet.Place;
import com.johnsully83.model.cloud.jpa.Country;
import com.johnsully83.service.workflow.helper.AbstractWorkflowHelperWrapper;

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

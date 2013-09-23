package com.home.service.workflow.helper.city;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.home.model.cloud.jpa.City;
import com.home.model.cloud.jpa.Country;
import com.home.service.workflow.helper.AbstractWorkflowHelperWrapper;
import com.jgeoplanet.Place;

public class CityWorkflowHelperWrapper extends AbstractWorkflowHelperWrapper<City, Integer> {
	private List<City> allEntities;
	private Map<Place, List<Place>> geoPlanetCities;
	
	private Country nextCountry;
	
	public CityWorkflowHelperWrapper(Country nextCountry) {
		super();
		this.allEntities = new ArrayList<City>();
		this.geoPlanetCities = new LinkedHashMap<Place, List<Place>>();
		this.nextCountry = nextCountry;
	}

	@Override
	public List<City> getAllEntities() {
		return allEntities;
	}

	public void setAllEntities(List<City> allEntities) {
		this.allEntities = allEntities;
	}
	
	public Map<Place, List<Place>> getGeoPlanetCities() {
		return geoPlanetCities;
	}

	public void setGeoPlanetCities(Map<Place, List<Place>> geoPlanetCities) {
		this.geoPlanetCities = geoPlanetCities;
	}

	public Country getNextCountry() {
		return nextCountry;
	}

	public void setNextCountry(Country nextCountry) {
		this.nextCountry = nextCountry;
	}

}

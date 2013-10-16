package com.johnsully83.model.datatable.view;

import com.johnsully83.model.cloud.mongo.MongoCity;

public class MongoCityView {
	private String name;
	private String stateName;
	private String countryName;
	
	public MongoCityView(MongoCity mongoCity) {
		super();
		this.name=mongoCity.getName();
		this.stateName=mongoCity.getState().getName();
		this.countryName=mongoCity.getCountry().getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}

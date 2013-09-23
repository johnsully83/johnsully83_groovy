package com.home.model.datatable.view;

import com.home.model.cloud.mongo.MongoState;

public class MongoStateView {
	private Integer stateID;
	private String countryName;
	private String name;
	
	public MongoStateView(MongoState mongoState) {
		super();
		this.stateID=mongoState.getId();
		this.countryName=mongoState.getCountry().getName();
		this.name=mongoState.getName();
	}

	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

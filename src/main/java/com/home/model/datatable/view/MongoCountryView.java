package com.home.model.datatable.view;

import com.home.model.cloud.mongo.MongoCountry;
import com.home.model.enumeration.main.YesNo;

public class MongoCountryView {
	private Integer countryID;
	private String name;
	private String hasStates;
	
	public MongoCountryView(MongoCountry mongoCountry) {
		super();
		this.countryID=mongoCountry.getId();
		this.name=mongoCountry.getName();
		this.hasStates=mongoCountry.getHasStates() ? YesNo.YES.value() : YesNo.NO.value();
	}

	public Integer getCountryID() {
		return countryID;
	}

	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHasStates() {
		return hasStates;
	}

	public void setHasStates(String hasStates) {
		this.hasStates = hasStates;
	}
}

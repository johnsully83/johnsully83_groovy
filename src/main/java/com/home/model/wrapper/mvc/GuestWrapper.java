package com.home.model.wrapper.mvc;

import java.util.Map;

import com.home.model.cloud.jpa.Country;
import com.home.model.cloud.jpa.State;

public interface GuestWrapper {

	public Country getUnitedStates();
	
	public State getMassachusetts();
	
	public Map<Integer, String> getCountries();
	
	public Map<Integer, String> getStates();

	public Map<Integer, String> getCities();
	
}

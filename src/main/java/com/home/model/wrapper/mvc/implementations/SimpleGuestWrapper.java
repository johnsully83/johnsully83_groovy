package com.home.model.wrapper.mvc.implementations;

import java.util.Map;

import com.home.model.cloud.jpa.Country;
import com.home.model.cloud.jpa.State;
import com.home.model.wrapper.mvc.GuestWrapper;

public class SimpleGuestWrapper implements GuestWrapper {
	private Country unitedStates;
	private State massachusetts;
	private Map<Integer, String> countries;
	private Map<Integer, String> states;
	private Map<Integer, String> cities;

	public SimpleGuestWrapper() {
		super();
	}

	@Override
	public Country getUnitedStates() {
		return unitedStates;
	}

	public void setUnitedStates(Country unitedStates) {
		this.unitedStates = unitedStates;
	}

	@Override
	public State getMassachusetts() {
		return massachusetts;
	}

	public void setMassachusetts(State massachusetts) {
		this.massachusetts = massachusetts;
	}

	@Override
	public Map<Integer, String> getCountries() {
		return countries;
	}

	public void setCountries(Map<Integer, String> countries) {
		this.countries = countries;
	}

	@Override
	public Map<Integer, String> getStates() {
		return states;
	}

	public void setStates(Map<Integer, String> states) {
		this.states = states;
	}

	@Override
	public Map<Integer, String> getCities() {
		return cities;
	}

	public void setCities(Map<Integer, String> cities) {
		this.cities = cities;
	}
	
}

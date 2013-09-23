package com.home.service.guest.simple;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.controller.guestbook.GuestbookController;
import com.home.model.cloud.jpa.City;
import com.home.model.cloud.jpa.Country;
import com.home.model.cloud.jpa.Guest;
import com.home.model.cloud.jpa.State;
import com.home.model.wrapper.mvc.GuestWrapper;
import com.home.model.wrapper.mvc.implementations.SimpleGuestWrapper;
import com.home.service.guest.GuestService;
import com.home.service.model.DtoService;

@Service("guestService")
public class SimpleGuestService implements GuestService {
	private final DtoService<Country, Integer> countryDtoService;
	private final DtoService<State, Integer> stateDtoService;
	private final DtoService<City, Integer> cityDtoService;
	private final DtoService<Guest, Integer> guestDtoService;
	
	@Autowired
	public SimpleGuestService(DtoService<Country, Integer> countryDtoService,
		DtoService<State, Integer> stateDtoService,
		DtoService<City, Integer> cityDtoService,
		DtoService<Guest, Integer> guestDtoService) {
		super();
		this.countryDtoService=countryDtoService;
		this.stateDtoService=stateDtoService;
		this.cityDtoService=cityDtoService;
		this.guestDtoService=guestDtoService;
	}
	
	@Override
	public GuestWrapper getLocaleInformationForForm() {
		SimpleGuestWrapper guestWrapper = new SimpleGuestWrapper();
		
		guestWrapper.setCountries(convertCountriesToIDs(countryDtoService.findAll()));
		guestWrapper.setUnitedStates(findUnitedStates());
		guestWrapper.setStates(convertStatesToIDs(stateDtoService.query("countryID = "+guestWrapper.getUnitedStates().getPk())));
		guestWrapper.setMassachusetts(findMassachusetts());
		guestWrapper.setCities(convertCitiesToIDs(cityDtoService.query("stateID = "+guestWrapper.getMassachusetts().getPk())));
		
		return guestWrapper;
	}

	@Override
	public String updateStateOptions(Integer countryID) {
		List<State> states = stateDtoService.query("countryID = "+countryID);
		
		return convertStatesToOptionsTags(states);
	}

	@Override
	public String updateCityOptions(Integer stateID) {
		List<City> cities = cityDtoService.query("stateID = "+stateID);
		
		return convertCitiesToOptionsTags(cities);
	}

	@Override
	public void addNewGuest(Guest newGuest) {
		guestDtoService.add(newGuest);
	}
	
	private Country findUnitedStates() {
		List<Country> countries = countryDtoService.query("name='United States'");
		
		if(countries.isEmpty()) {
			return countryDtoService.find(GuestbookController.getUnitedStatesCountryID());
		}
		
		return countries.get(0);
	}
	
	private State findMassachusetts() {
		List<State> states = stateDtoService.query("name='Massachusetts'");
		
		if(states.isEmpty()) {
			return stateDtoService.find(GuestbookController.getMassachusettsStateID());
		}
		
		return states.get(0);
	}

	private Map<Integer, String> convertCountriesToIDs(List<Country> countries) {
		Map<Integer, String> countryIDs = new LinkedHashMap<Integer, String>();
		
		for(Country country : countries) {
			countryIDs.put(country.getPk(), country.getName());
		}
		
		return countryIDs;
	}

	private Map<Integer, String> convertStatesToIDs(List<State> states) {
		Map<Integer, String> stateIDs = new LinkedHashMap<Integer, String>();
		
		for(State state : states) {
			stateIDs.put(state.getPk(), state.getName());
		}
		
		return stateIDs;
	}

	private Map<Integer, String> convertCitiesToIDs(List<City> cities) {
		Map<Integer, String> cityIDs = new LinkedHashMap<Integer, String>();
		
		for(City city : cities) {
			cityIDs.put(city.getPk(), city.getName());
		}
		
		return cityIDs;
	}

	private String convertStatesToOptionsTags(List<State> states) {
		StringBuilder builder = new StringBuilder();
		
		for(State state : states) {
			builder.append("<option value='"+state.getPk()+"'>"+state.getName()+"</option>");
		}
		
		return builder.toString();
	}

	private String convertCitiesToOptionsTags(List<City> cities) {
		StringBuilder builder = new StringBuilder();
		
		for(City city : cities) {
			builder.append("<option value='"+city.getPk()+"'>"+city.getName()+"</option>");
		}
		
		return builder.toString();
	}
	
}

package com.home.service.guest;

import com.home.model.cloud.jpa.Guest;
import com.home.model.wrapper.mvc.GuestWrapper;

public interface GuestService {
	
	public GuestWrapper getLocaleInformationForForm();
	
	public String updateStateOptions(Integer countryID);

	public String updateCityOptions(Integer stateID);
	
	public void addNewGuest(Guest newGuest);
	
}

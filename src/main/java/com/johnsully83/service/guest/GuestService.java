package com.johnsully83.service.guest;

import com.johnsully83.model.cloud.jpa.Guest;
import com.johnsully83.model.wrapper.mvc.GuestWrapper;

public interface GuestService {
	
	public GuestWrapper getLocaleInformationForForm();
	
	public String updateStateOptions(Integer countryID);

	public String updateCityOptions(Integer stateID);
	
	public void addNewGuest(Guest newGuest);
	
}

package com.home.controller.guestbook;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.model.cloud.jpa.City;
import com.home.model.cloud.jpa.Country;
import com.home.model.cloud.jpa.Guest;
import com.home.model.cloud.jpa.State;
import com.home.model.wrapper.mvc.GuestWrapper;
import com.home.service.email.EmailService;
import com.home.service.guest.GuestService;
import com.home.service.propertyEditor.DtoPropertyEditor;
import com.home.service.propertyEditor.field.DatePropertyEditor;
import com.home.service.validation.FormValidator;

@Controller
@RequestMapping(value="guestbook/*")
public class GuestbookController {
	
	private final GuestService guestService;
	private final EmailService emailService;
	private final FormValidator formValidator;

	private final DtoPropertyEditor<City, Integer> cityPropertyEditor;
	private final DtoPropertyEditor<State, Integer> statePropertyEditor;
	private final DtoPropertyEditor<Country, Integer> countryPropertyEditor;
	private final DatePropertyEditor datePropertyEditor;
	
	private static Integer UNITEDSTATESCOUNTRYID=203;
	private static Integer MASSACHUSETTSSTATEID=3073;
	
	@Autowired
	public GuestbookController(GuestService guestService, EmailService emailService, 
			FormValidator formValidator, DatePropertyEditor datePropertyEditor,
			@Qualifier("statePropertyEditor") DtoPropertyEditor<State, Integer> statePropertyEditor,
			@Qualifier("countryPropertyEditor") DtoPropertyEditor<Country, Integer> countryPropertyEditor,
			@Qualifier("cityPropertyEditor") DtoPropertyEditor<City, Integer> cityPropertyEditor) {
		super();
		this.guestService=guestService;
		this.emailService=emailService;
		this.formValidator=formValidator;
		this.datePropertyEditor=datePropertyEditor;
		this.statePropertyEditor=statePropertyEditor;
		this.countryPropertyEditor=countryPropertyEditor;
		this.cityPropertyEditor=cityPropertyEditor;
	}
	
	@RequestMapping(value="getGuestbookForm", method={RequestMethod.GET})
	public String getGuestbookForm(Model model) {
		GuestWrapper guestWrapper = guestService.getLocaleInformationForForm();
		
		model.addAttribute("countries", guestWrapper.getCountries());
		model.addAttribute("states", guestWrapper.getStates());
		model.addAttribute("cities", guestWrapper.getCities());
		model.addAttribute("unitedStatesCountryID", guestWrapper.getUnitedStates().getPk());
		model.addAttribute("massachusettsStateID", guestWrapper.getMassachusetts().getPk());
		
		GuestbookController.UNITEDSTATESCOUNTRYID=guestWrapper.getUnitedStates().getPk();
		GuestbookController.MASSACHUSETTSSTATEID=guestWrapper.getMassachusetts().getPk();
		
		return "guestbook";
	}
	
	@RequestMapping(value="save", method={RequestMethod.POST})
	public String save(@Valid @ModelAttribute Guest newGuest, BindingResult result, Model model, HttpServletResponse response) {	
		
		if(result.hasErrors()) {
			GuestWrapper guestWrapper = guestService.getLocaleInformationForForm();
			
			model.addAttribute("countries", guestWrapper.getCountries());
			model.addAttribute("states", guestWrapper.getStates());
			model.addAttribute("cities", guestWrapper.getCities());

			GuestbookController.UNITEDSTATESCOUNTRYID=guestWrapper.getUnitedStates().getPk();
			GuestbookController.MASSACHUSETTSSTATEID=guestWrapper.getMassachusetts().getPk();
			
			return "guestbook";
		}
		
		guestService.addNewGuest(newGuest);
		emailService.sendThankyouEmail(newGuest.getEmail(), newGuest.getName());
		
		return "thankyou";
	}
	
	@RequestMapping(value="getStates", method={RequestMethod.GET}, produces="text/html")
	@ResponseBody
	public String getStates(@RequestParam("countryID") Integer countryID) {
		return guestService.updateStateOptions(countryID);
	}
	
	@RequestMapping(value="getCities", method={RequestMethod.GET}, produces="text/html")
	@ResponseBody
	public String getCities(@RequestParam("stateID") Integer stateID) {
		return guestService.updateCityOptions(stateID);
	}
	
	@ModelAttribute
	public void getNewGuest(Model model) {
		Guest guest = new Guest();
		
		model.addAttribute("guest", guest);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(formValidator);
		
		binder.registerCustomEditor(Date.class, "dateAdded", datePropertyEditor);
		binder.registerCustomEditor(Date.class, "dateLastModified", datePropertyEditor);
		binder.registerCustomEditor(State.class, "state", statePropertyEditor);
		binder.registerCustomEditor(Country.class, "country", countryPropertyEditor);
		binder.registerCustomEditor(City.class, "city", cityPropertyEditor);
	}
	
	public static Integer getUnitedStatesCountryID() {
		return GuestbookController.UNITEDSTATESCOUNTRYID;
	}

	public static Integer getMassachusettsStateID() {
		return GuestbookController.MASSACHUSETTSSTATEID;
	}

}

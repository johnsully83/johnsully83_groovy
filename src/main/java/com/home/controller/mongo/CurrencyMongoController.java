package com.home.controller.mongo;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.AppSettings;
import com.home.exceptions.SullyException;
import com.home.exceptions.implementations.NoCurrenciesException;
import com.home.model.form.CurrencyForm;
import com.home.model.wrapper.mvc.CurrencyWrapper;
import com.home.service.currency.CurrencyService;

@Controller
@RequestMapping("/mongo/*")
public class CurrencyMongoController {
	private final Logger log = Logger.getLogger(CurrencyMongoController.class);
	
	private final CurrencyService currencyService;
	
	@Autowired
	public CurrencyMongoController(CurrencyService currencyService,
			AppSettings appSettings) {
		super();
		this.currencyService=currencyService;
	}
	
	@ModelAttribute(value="currencyForm")
	public void getNewCurrencyForm(Model model) {
		model.addAttribute("currencyForm", new CurrencyForm());
	}

	@RequestMapping("getCurrencyForm")
	public String getCurrencyForm(HttpServletRequest request, Model model) throws SullyException {
		try {
			CurrencyWrapper currencyWrapper = currencyService.getCurrencyFormInfo();
			
			model.addAttribute("currencies", currencyWrapper.getCurrencies());
			model.addAttribute("timestamps", currencyWrapper.getTimestamps());
		} catch(Exception e) {
			model.addAttribute("error", "Error getting information from cloud; try again later...");
			log.error("Error getting currency information for form", e);
		}
		
		return "code/currency";
	}

	@ResponseBody
	@RequestMapping(value="currencyValue", method={RequestMethod.GET}, produces="application/json")
	public String getCurrencyValue(HttpServletRequest request, @ModelAttribute CurrencyForm currencyForm) throws SullyException, JSONException {
		
		BigDecimal value = new BigDecimal(0);
		
		try {
			value = currencyService.getCurrencyValue(currencyForm);
		} catch(NoCurrenciesException e) {
			log.error("Error getting currency information for form", e);
			value = new BigDecimal(-1);
		} catch(Exception e) {
			log.error("Error getting currency information for form", e);
		}
		
		return value.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}

}

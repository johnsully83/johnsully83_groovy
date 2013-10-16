package com.johnsully83.service.api;

import java.util.Map;

import com.johnsully83.model.json.OpenExchangeLatestRates;

public interface OpenExchangeService {
	
	public OpenExchangeLatestRates getLatestRates();
	
	public Map<String, String> getCurrencies();

}

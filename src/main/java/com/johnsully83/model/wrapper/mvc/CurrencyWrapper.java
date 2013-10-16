package com.johnsully83.model.wrapper.mvc;

import java.math.BigDecimal;
import java.util.Map;

public interface CurrencyWrapper {
	
	public Map<Integer, String> getTimestamps();
	
	public Map<String, String> getCurrencies();
	
	public BigDecimal getValue();

}

package com.home.model.wrapper.mvc.implementations;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import com.home.model.wrapper.mvc.CurrencyWrapper;

public class SimpleCurrencyWrapper implements CurrencyWrapper {
	
	private Map<Integer, String> timestamps;
	private Map<String, String> currencies;
	private BigDecimal value;
	
	public SimpleCurrencyWrapper() {
		super();
		this.timestamps = new LinkedHashMap<Integer, String>();
		this.currencies = new LinkedHashMap<String, String>();
	}

	@Override
	public Map<Integer, String> getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(Map<Integer, String> timestamps) {
		this.timestamps = timestamps;
	}

	@Override
	public Map<String, String> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(Map<String, String> currencies) {
		this.currencies = currencies;
	}

	@Override
	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}

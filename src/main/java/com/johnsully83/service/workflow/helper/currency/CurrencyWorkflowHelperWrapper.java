package com.johnsully83.service.workflow.helper.currency;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.johnsully83.model.cloud.jpa.CurrencyValue;
import com.johnsully83.model.cloud.jpa.LatestRates;
import com.johnsully83.service.workflow.helper.AbstractWorkflowHelperWrapper;

public class CurrencyWorkflowHelperWrapper extends AbstractWorkflowHelperWrapper<LatestRates, Integer> {
	private List<LatestRates> allEntities;
	private Map<String, Double> currencyValues;
	private Map<String, String> currencies;
	private List<CurrencyValue> replicatedCurrencies;

	public CurrencyWorkflowHelperWrapper() {
		super();
		this.allEntities = new ArrayList<LatestRates>();
		this.currencyValues = new LinkedHashMap<String, Double>();
		this.currencies = new LinkedHashMap<String, String>();
		this.replicatedCurrencies = new ArrayList<CurrencyValue>();
	}

	@Override
	public List<LatestRates> getAllEntities() {
		return allEntities;
	}

	public void setAllEntities(List<LatestRates> allEntities) {
		this.allEntities = allEntities;
	}

	public Map<String, Double> getCurrencyValues() {
		return currencyValues;
	}

	public void setCurrencyValues(Map<String, Double> currencyValues) {
		this.currencyValues = currencyValues;
	}

	public Map<String, String> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(Map<String, String> currencies) {
		this.currencies = currencies;
	}

	public List<CurrencyValue> getReplicatedCurrencies() {
		return replicatedCurrencies;
	}

	public void setReplicatedCurrencies(List<CurrencyValue> replicatedCurrencies) {
		this.replicatedCurrencies = replicatedCurrencies;
	}

}
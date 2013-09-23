package com.home.model.openexchange;

import java.util.LinkedHashMap;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonPropertyOrder(value = { "disclaimer", "license", "timestamp", "base", "rates" })
@JsonIgnoreProperties(ignoreUnknown=true)
public class OpenExchangeLatestRates {
	private String disclaimer;
	private String license;
	private Integer timestamp;
	private String base;
	@JsonDeserialize(keyAs=String.class, contentAs=Double.class, as=LinkedHashMap.class)
	@JsonProperty(value="rates")
	private LinkedHashMap<String, Double> rates;
	
	public OpenExchangeLatestRates() {
		super();
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public LinkedHashMap<String, Double> getRates() {
		return rates;
	}

	public void setRates(LinkedHashMap<String, Double> rates) {
		this.rates = rates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base == null) ? 0 : base.hashCode());
		result = prime * result
				+ ((disclaimer == null) ? 0 : disclaimer.hashCode());
		result = prime * result + ((license == null) ? 0 : license.hashCode());
		result = prime * result + ((rates == null) ? 0 : rates.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpenExchangeLatestRates other = (OpenExchangeLatestRates) obj;
		if (base == null) {
			if (other.base != null)
				return false;
		} else if (!base.equals(other.base))
			return false;
		if (disclaimer == null) {
			if (other.disclaimer != null)
				return false;
		} else if (!disclaimer.equals(other.disclaimer))
			return false;
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		if (rates == null) {
			if (other.rates != null)
				return false;
		} else if (!rates.equals(other.rates))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OpenExchangeLatestRates [disclaimer=" + disclaimer
				+ ", license=" + license + ", timestamp=" + timestamp
				+ ", base=" + base + ", rates=" + rates + "]";
	}
	
}

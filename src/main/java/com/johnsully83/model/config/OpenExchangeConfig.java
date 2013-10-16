package com.johnsully83.model.config;

public class OpenExchangeConfig {
	private final String openExchangeBaseUrl;
	private final String openExchangeTypeListEndpoint;
	private final String openExchangeLatestRatesEndpoint;
	private final String openExchangeApiKey;
	
	public OpenExchangeConfig(String openExchangeBaseUrl, String openExchangeTypeListEndpoint,
			String openExchangeLatestRatesEndpoint, String openExchangeApiKey) {
		super();
		this.openExchangeBaseUrl = openExchangeBaseUrl;
		this.openExchangeTypeListEndpoint = openExchangeTypeListEndpoint;
		this.openExchangeLatestRatesEndpoint = openExchangeLatestRatesEndpoint;
		this.openExchangeApiKey = openExchangeApiKey;
	}

	public String getOpenExchangeBaseUrl() {
		return openExchangeBaseUrl;
	}

	public String getOpenExchangeTypeListEndpoint() {
		return openExchangeTypeListEndpoint;
	}

	public String getOpenExchangeLatestRatesEndpoint() {
		return openExchangeLatestRatesEndpoint;
	}

	public String getOpenExchangeApiKey() {
		return openExchangeApiKey;
	}
	
}

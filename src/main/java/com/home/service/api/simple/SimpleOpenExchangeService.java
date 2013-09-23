package com.home.service.api.simple;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.home.model.config.OpenExchangeConfig;
import com.home.model.json.OpenExchangeLatestRates;
import com.home.service.api.OpenExchangeService;

@Service("openExchangeService")
public class SimpleOpenExchangeService implements OpenExchangeService {
	private final RestTemplate restTemplate;
	private final OpenExchangeConfig openExchangeConfig;
	
	@Autowired
	public SimpleOpenExchangeService(RestTemplate restTemplate, OpenExchangeConfig openExchangeConfig) {
		super();
		this.restTemplate=restTemplate;
		this.openExchangeConfig=openExchangeConfig;
	}

	@Override
	public OpenExchangeLatestRates getLatestRates() {
		StringBuilder url = new StringBuilder(openExchangeConfig.getOpenExchangeBaseUrl()+openExchangeConfig.getOpenExchangeLatestRatesEndpoint());
		url.append("?app_id="+openExchangeConfig.getOpenExchangeApiKey());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

		OpenExchangeLatestRates openExchangeLatestRates = 
				restTemplate.exchange(url.toString(), HttpMethod.GET, requestEntity, OpenExchangeLatestRates.class).getBody();
		
		return openExchangeLatestRates;
	}

	@Override
	public Map<String, String> getCurrencies() {
		StringBuilder url = new StringBuilder(openExchangeConfig.getOpenExchangeBaseUrl()+openExchangeConfig.getOpenExchangeTypeListEndpoint());
		url.append("?app_id="+openExchangeConfig.getOpenExchangeApiKey());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		
		ParameterizedTypeReference<Map<String, String>> typeReference = new ParameterizedTypeReference<Map<String, String>>() {};
		
		Map<String, String> currencies = restTemplate.exchange(url.toString(), HttpMethod.GET, requestEntity, typeReference).getBody();
		
		return currencies;
	}

}

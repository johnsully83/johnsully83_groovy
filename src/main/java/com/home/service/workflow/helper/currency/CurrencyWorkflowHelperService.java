package com.home.service.workflow.helper.currency;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.home.AppContext;
import com.home.dao.MongoDao;
import com.home.exceptions.implementations.NoCurrenciesException;
import com.home.exceptions.implementations.NoCurrencyValueException;
import com.home.model.cloud.jpa.Currency;
import com.home.model.cloud.jpa.CurrencyValue;
import com.home.model.cloud.jpa.LatestRates;
import com.home.model.cloud.mongo.MongoCurrency;
import com.home.model.json.OpenExchangeLatestRates;
import com.home.service.api.OpenExchangeService;
import com.home.service.model.DtoService;
import com.home.service.workflow.helper.AbstractWorkflowHelperService;
import com.home.workflow.traversing.implementations.CurrencyTraverser;

public class CurrencyWorkflowHelperService extends AbstractWorkflowHelperService<LatestRates, Integer> {
	private final Logger log = Logger.getLogger(CurrencyWorkflowHelperService.class);
	
	private final DtoService<Currency, Integer> currencyDtoService;
	private final DtoService<CurrencyValue, Integer> currencyValueDtoService;
	private final DtoService<LatestRates, Integer> latestRatesDtoService;
	private final MongoDao<MongoCurrency, Integer> currencyMongoDao;
	
	private final OpenExchangeService openExchangeService;

	@SuppressWarnings("unchecked")
	public CurrencyWorkflowHelperService() {
		super(AppContext.getApplicationContext().getBean("latestRatesDtoService", DtoService.class));
		this.currencyDtoService=AppContext.getApplicationContext().getBean("currencyDtoService", DtoService.class);
		this.currencyValueDtoService=AppContext.getApplicationContext().getBean("currencyValueDtoService", DtoService.class);
		this.latestRatesDtoService=AppContext.getApplicationContext().getBean("latestRatesDtoService", DtoService.class);
		this.currencyMongoDao=AppContext.getApplicationContext().getBean("currencyMongoDao", MongoDao.class);
		this.openExchangeService=AppContext.getApplicationContext().getBean("openExchangeService", OpenExchangeService.class);
	}
	
	public void queryForLatestRates(CurrencyTraverser tasks) {
		Map<String, String> currencies = openExchangeService.getCurrencies();
		OpenExchangeLatestRates latestRates = openExchangeService.getLatestRates();

		tasks.getWorkflowHelperWrapper().setCurrencies(currencies);
		tasks.getWorkflowHelperWrapper().setAllEntities(Collections.singletonList(new LatestRates(latestRates)));
		tasks.getWorkflowHelperWrapper().setCurrencyValues(latestRates.getRates());
	}

	public void convertCurrenciesAndMerge(CurrencyTraverser tasks) throws NoCurrenciesException {
		if(tasks.getWorkflowHelperWrapper().getAllEntities().isEmpty()) {
			throw new NoCurrenciesException("LatestRates list was empty when we went to merge");
		}
		
		LatestRates latestRates = tasks.getWorkflowHelperWrapper().getAllEntities().get(0);
		
		String where = "timestamp = "+latestRates.getTimestamp();
		
		if(!latestRatesDtoService.query(where).isEmpty()) {
			log.info("Already found currency rates for current timestamp "+latestRates.getTimestamp()+" stopping processing...");
			
			String findAllCurrenciesForNow = "a.latestRates.timestamp = "+latestRates.getTimestamp();
			
			List<CurrencyValue> currencyValues = currencyValueDtoService.query(findAllCurrenciesForNow);
			
			tasks.getWorkflowHelperWrapper().setReplicatedCurrencies(currencyValues);
			
			return;
		}
		
		latestRates = latestRatesDtoService.merge(latestRates);
		
		for(Map.Entry<String, String> entry : tasks.getWorkflowHelperWrapper().getCurrencies().entrySet()) {
			try {
				transformAndMerge(tasks, entry, latestRates);
			} catch(NoCurrencyValueException e) {
				log.error("", e);
			}
		}
	}
	
	public void replicateToMongoDB(CurrencyTraverser tasks) {
		for(CurrencyValue currencyValue : tasks.getWorkflowHelperWrapper().getReplicatedCurrencies()) {
			MongoCurrency mongoCurrency = new MongoCurrency(currencyValue);
			
			currencyMongoDao.merge(mongoCurrency);
		}
	}
	
	private void transformAndMerge(CurrencyTraverser tasks, Map.Entry<String, String> entry, LatestRates latestRates) throws NoCurrencyValueException {
		Currency currency = new Currency(entry.getKey(), entry.getValue());
		
		String where = "currencyCode = '"+currency.getCurrencyCode()+"'";
		
		List<Currency> results = currencyDtoService.query(where);
		
		if(results.isEmpty()) {
			currency = currencyDtoService.merge(currency);
		} else {
			currency = results.get(0);
		}
		
		String code = currency.getCurrencyCode();
		
		Double value = tasks.getWorkflowHelperWrapper().getCurrencyValues().get(code);
		
		if(value == null) {
			throw new NoCurrencyValueException(code, "Could not find the following country code's value: "+code);
		}
		
		CurrencyValue currencyValue = new CurrencyValue(currency, latestRates, new BigDecimal(value));
		
		currencyValue = currencyValueDtoService.merge(currencyValue);
		
		tasks.getWorkflowHelperWrapper().getReplicatedCurrencies().add(currencyValue);
	}

}

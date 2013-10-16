package com.johnsully83.service.currency.simple;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.johnsully83.AppSettings;
import com.johnsully83.dao.MongoDao;
import com.johnsully83.exceptions.implementations.NoCurrenciesException;
import com.johnsully83.model.cloud.jpa.Currency;
import com.johnsully83.model.cloud.jpa.LatestRates;
import com.johnsully83.model.cloud.mongo.MongoCurrency;
import com.johnsully83.model.form.CurrencyForm;
import com.johnsully83.model.wrapper.mvc.CurrencyWrapper;
import com.johnsully83.model.wrapper.mvc.implementations.SimpleCurrencyWrapper;
import com.johnsully83.service.currency.CurrencyService;
import com.johnsully83.service.model.DtoService;

@Service("currencyService")
public class SimpleCurrencyService implements CurrencyService {
	
	private final DtoService<LatestRates, Integer> latestRatesDtoService;
	private final DtoService<Currency, Integer> currencyDtoService;
	private final MongoDao<MongoCurrency, Integer> currencyMongoDao;
	
	private final AppSettings appSettings;
	
	@Autowired
	public SimpleCurrencyService(
			@Qualifier("latestRatesDtoService") DtoService<LatestRates, Integer> latestRatesDtoService,
			@Qualifier("currencyDtoService") DtoService<Currency, Integer> currencyDtoService,
			@Qualifier("currencyMongoDao") MongoDao<MongoCurrency, Integer> currencyMongoDao,
			AppSettings appSettings) {
		super();
		this.latestRatesDtoService = latestRatesDtoService;
		this.currencyDtoService = currencyDtoService;
		this.currencyMongoDao = currencyMongoDao;
		this.appSettings = appSettings;
	}

	@Override
	public CurrencyWrapper getCurrencyFormInfo() {
		SimpleCurrencyWrapper currencyWrapper = new SimpleCurrencyWrapper();
		
		List<LatestRates> allLatestRates = latestRatesDtoService.findAll("timestamp DESC");
		List<Currency> currencies = currencyDtoService.findAll("name ASC");
		
		for(LatestRates latestRates : allLatestRates) {
			DateTime date = new DateTime(latestRates.getTimestamp().longValue()*1000);
			
			currencyWrapper.getTimestamps().put(latestRates.getTimestamp(), date.toString(appSettings.getDateFormat()));
		}
		
		for(Currency currency : currencies) {
			currencyWrapper.getCurrencies().put(currency.getCurrencyCode(), currency.getName());
		}
		
		return currencyWrapper;
	}

	@Override
	public BigDecimal getCurrencyValue(CurrencyForm currencyForm) throws NoCurrenciesException {
		Criteria fromCriteria = Criteria.where("timestamp").is(currencyForm.getTimestamp())
			.and("currencyCode").is(currencyForm.getFromCurrencyCode());
		
		List<MongoCurrency> fromCurrencies = currencyMongoDao.query(fromCriteria);

		Criteria toCriteria = Criteria.where("timestamp").is(currencyForm.getTimestamp())
			.and("currencyCode").is(currencyForm.getToCurrencyCode());
		
		List<MongoCurrency> toCurrencies = currencyMongoDao.query(toCriteria);
		
		if(fromCurrencies.isEmpty() || toCurrencies.isEmpty()) {
			throw new NoCurrenciesException(currencyForm.getFromCurrencyCode(), currencyForm.getToCurrencyCode(), currencyForm.getTimestamp());
		}
		
		MongoCurrency fromCurrency = fromCurrencies.get(0);
		MongoCurrency toCurrency = toCurrencies.get(0);
		
		BigDecimal fromCurrencyInUsd = BigDecimal.ONE.divide(fromCurrency.getValue(), 10, BigDecimal.ROUND_HALF_UP)
				.multiply(currencyForm.getAmountFrom());
		
		return fromCurrencyInUsd.multiply(toCurrency.getValue());
	}

}

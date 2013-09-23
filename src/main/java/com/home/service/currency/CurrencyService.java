package com.home.service.currency;

import java.math.BigDecimal;

import com.home.exceptions.implementations.NoCurrenciesException;
import com.home.model.form.CurrencyForm;
import com.home.model.wrapper.mvc.CurrencyWrapper;

public interface CurrencyService {

	public CurrencyWrapper getCurrencyFormInfo();

	public BigDecimal getCurrencyValue(CurrencyForm currencyForm) throws NoCurrenciesException;
	
}

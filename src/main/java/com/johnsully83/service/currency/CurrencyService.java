package com.johnsully83.service.currency;

import java.math.BigDecimal;

import com.johnsully83.exceptions.implementations.NoCurrenciesException;
import com.johnsully83.model.form.CurrencyForm;
import com.johnsully83.model.wrapper.mvc.CurrencyWrapper;

public interface CurrencyService {

	public CurrencyWrapper getCurrencyFormInfo();

	public BigDecimal getCurrencyValue(CurrencyForm currencyForm) throws NoCurrenciesException;
	
}

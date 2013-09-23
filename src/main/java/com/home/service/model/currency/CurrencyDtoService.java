package com.home.service.model.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.home.dao.JpaDao;
import com.home.model.cloud.jpa.Currency;
import com.home.service.model.AbstractDtoService;

@Service("currencyDtoService")
public class CurrencyDtoService extends AbstractDtoService<Currency, Integer> {

	@Autowired
	protected CurrencyDtoService(@Qualifier("currencyDao") JpaDao<Currency, Integer> currencyDao) {
		super(currencyDao);
	}

}

package com.johnsully83.service.model.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.johnsully83.dao.JpaDao;
import com.johnsully83.model.cloud.jpa.Currency;
import com.johnsully83.service.model.AbstractDtoService;

@Service("currencyDtoService")
public class CurrencyDtoService extends AbstractDtoService<Currency, Integer> {

	@Autowired
	protected CurrencyDtoService(@Qualifier("currencyDao") JpaDao<Currency, Integer> currencyDao) {
		super(currencyDao);
	}

}

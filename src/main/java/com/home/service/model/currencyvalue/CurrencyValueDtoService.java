package com.home.service.model.currencyvalue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.home.dao.JpaDao;
import com.home.model.cloud.jpa.CurrencyValue;
import com.home.service.model.AbstractDtoService;

@Service("currencyValueDtoService")
public class CurrencyValueDtoService extends AbstractDtoService<CurrencyValue, Integer> {

	@Autowired
	public CurrencyValueDtoService(@Qualifier("currencyValueDao") JpaDao<CurrencyValue, Integer> currencyValueDao) {
		super(currencyValueDao);
	}

}

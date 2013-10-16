package com.johnsully83.service.model.currencyvalue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.johnsully83.dao.JpaDao;
import com.johnsully83.model.cloud.jpa.CurrencyValue;
import com.johnsully83.service.model.AbstractDtoService;

@Service("currencyValueDtoService")
public class CurrencyValueDtoService extends AbstractDtoService<CurrencyValue, Integer> {

	@Autowired
	public CurrencyValueDtoService(@Qualifier("currencyValueDao") JpaDao<CurrencyValue, Integer> currencyValueDao) {
		super(currencyValueDao);
	}

}

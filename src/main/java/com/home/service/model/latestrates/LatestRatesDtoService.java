package com.home.service.model.latestrates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.home.dao.JpaDao;
import com.home.model.cloud.jpa.LatestRates;
import com.home.service.model.AbstractDtoService;

@Service("latestRatesDtoService")
public class LatestRatesDtoService extends AbstractDtoService<LatestRates, Integer> {

	@Autowired
	public LatestRatesDtoService(@Qualifier("latestRatesDao") JpaDao<LatestRates, Integer> cloudTableDao) {
		super(cloudTableDao);
	}

}

package com.johnsully83.service.model.latestrates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.johnsully83.dao.JpaDao;
import com.johnsully83.model.cloud.jpa.LatestRates;
import com.johnsully83.service.model.AbstractDtoService;

@Service("latestRatesDtoService")
public class LatestRatesDtoService extends AbstractDtoService<LatestRates, Integer> {

	@Autowired
	public LatestRatesDtoService(@Qualifier("latestRatesDao") JpaDao<LatestRates, Integer> cloudTableDao) {
		super(cloudTableDao);
	}

}

package com.johnsully83.service.model.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnsully83.dao.JpaDao;
import com.johnsully83.model.cloud.jpa.Country;
import com.johnsully83.service.model.AbstractDtoService;

@Service("countryDtoService")
public class CountryDtoService extends AbstractDtoService<Country, Integer> {

	@Autowired
	public CountryDtoService(@Qualifier("countryDao") JpaDao<Country, Integer> countryDao) {
		super(countryDao);
	}
	
	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public List<Country> findAll() {
		return getCloudTableDao().query("1=1 ORDER BY name");
	}

}

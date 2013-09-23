package com.home.service.model.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.dao.JpaDao;
import com.home.model.cloud.jpa.City;
import com.home.service.model.AbstractDtoService;

@Service("cityDtoService")
public class CityDtoService extends AbstractDtoService<City, Integer> {

	@Autowired
	public CityDtoService(@Qualifier("cityDao") JpaDao<City, Integer> cityDao) {
		super(cityDao);
	}
	
	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public List<City> findAll() {
		return getCloudTableDao().query("1=1 ORDER BY name");
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public List<City> query(String where) {
		return getCloudTableDao().query(where+" ORDER BY name");
	}

}

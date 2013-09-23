package com.home.service.model.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.dao.JpaDao;
import com.home.model.cloud.jpa.State;
import com.home.service.model.AbstractDtoService;

@Service("stateDtoService")
public class StateDtoService extends AbstractDtoService<State, Integer> {

	@Autowired
	public StateDtoService(@Qualifier("stateDao") JpaDao<State, Integer> stateDao) {
		super(stateDao);
	}
	
	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public List<State> findAll() {
		return getCloudTableDao().query("1=1 ORDER BY name");
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public List<State> query(String where) {
		return getCloudTableDao().query(where+" ORDER BY name");
	}

}

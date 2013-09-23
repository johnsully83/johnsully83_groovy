package com.home.service.model.prime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.home.dao.JpaDao;
import com.home.model.cloud.jpa.Prime;
import com.home.service.model.AbstractDtoService;

@Service("primeDtoService")
public class PrimeDtoService extends AbstractDtoService<Prime, Integer> {
	
	@Autowired
	public PrimeDtoService(@Qualifier("primeDao") JpaDao<Prime, Integer> primeDao) {
		super(primeDao);
	}
	
}

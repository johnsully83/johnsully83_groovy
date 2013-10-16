package com.johnsully83.service.model.prime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.johnsully83.dao.JpaDao;
import com.johnsully83.model.cloud.jpa.Prime;
import com.johnsully83.service.model.AbstractDtoService;

@Service("primeDtoService")
public class PrimeDtoService extends AbstractDtoService<Prime, Integer> {
	
	@Autowired
	public PrimeDtoService(@Qualifier("primeDao") JpaDao<Prime, Integer> primeDao) {
		super(primeDao);
	}
	
}

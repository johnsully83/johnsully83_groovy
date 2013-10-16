package com.johnsully83.service.primes.simple;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.johnsully83.dao.MongoDao;
import com.johnsully83.exceptions.SullyException;
import com.johnsully83.model.cloud.mongo.MongoPrime;
import com.johnsully83.model.datatable.JQueryDataTableParameter;
import com.johnsully83.service.primes.PrimesService;
import com.johnsully83.utility.Utility;

@Service("primesService")
public class SimplePrimesService implements PrimesService {
	
	private final MongoDao<MongoPrime, Integer> primeMongoDao;
	
	@Autowired
	public SimplePrimesService(@Qualifier("primeMongoDao") MongoDao<MongoPrime, Integer> primeMongoDao) {
		super();
		this.primeMongoDao=primeMongoDao;
	}

	@Override
	public BigInteger findPrime(JQueryDataTableParameter parameters) throws SullyException {
		if(parameters.getFindPrime() == null || parameters.getFindPrime().isEmpty()) {
			throw new SullyException("No parameter sent to server for prime finding call", new NullPointerException());
		}
		
		MongoPrime prime = primeMongoDao.find(Utility.forceParseInteger(parameters.getFindPrime()));
		
		if(prime == null) {
			return BigInteger.valueOf(-1);
		}
		
		return prime.getPrime();
	}

}

package com.johnsully83.events.prime.simple;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;

import com.johnsully83.dao.MongoDao;
import com.johnsully83.events.prime.PrimeFinder;
import com.johnsully83.model.cloud.mongo.MongoPrime;

public class SimplePrimeFinder implements PrimeFinder {
	private final Logger log = Logger.getLogger(SimplePrimeFinder.class);

	private final MongoDao<MongoPrime, Integer> primeMongoDao;
	
	@Autowired
	public SimplePrimeFinder(@Qualifier("primeMongoDao") MongoDao<MongoPrime, Integer> primeMongoDao) {
		super();
		this.primeMongoDao=primeMongoDao;
	}
	
	@Override
	public void find() {
		log.info("Beginning prime finding...");
		MongoPrime prime;
		
		List<MongoPrime> primeResults = primeMongoDao.query(null, new Sort(Sort.Direction.DESC, "_id"), 1);
		
		if(primeResults.isEmpty()) {
			prime = new MongoPrime(1, BigInteger.valueOf(2));
			
			prime = primeMongoDao.merge(prime);
		} else {
			prime = primeResults.get(0);
		}
		
		
		while(true) {
			MongoPrime nextPrime = getNextPrime(prime);

			primeMongoDao.merge(nextPrime);
			
			if(nextPrime.getPrime().subtract(BigInteger.ONE).mod(BigInteger.valueOf(173)).equals(BigInteger.ZERO)) {
				log.info("Prime: "+nextPrime.getPrime());
			}
			
			prime = nextPrime;
		}
	}

	private MongoPrime getNextPrime(MongoPrime prime) {
		BigInteger largestCurrentPrime = prime.getPrime();
		
		if(largestCurrentPrime.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
			largestCurrentPrime = largestCurrentPrime.add(BigInteger.ONE);
		} else {
			largestCurrentPrime = largestCurrentPrime.add(BigInteger.valueOf(2));
		}
		
		while(isNotPrime(largestCurrentPrime)) {
			largestCurrentPrime = largestCurrentPrime.add(BigInteger.valueOf(2));
		}
		
		return new MongoPrime(prime.getId()+1, largestCurrentPrime);
	}

	private boolean isNotPrime(BigInteger value) {
		BigDecimal decimalValue = new BigDecimal(value);
		
		BigInteger max = new BigDecimal(Math.sqrt(decimalValue.doubleValue())).setScale(0, BigDecimal.ROUND_UP).toBigInteger();
		
		for(BigInteger check = BigInteger.valueOf(3); check.compareTo(max) <=0; check = check.add(BigInteger.valueOf(2))) {
			if(value.mod(check).compareTo(BigInteger.valueOf(0)) == 0) {
				return true;
			}
		}
		
		return false;
	}

}
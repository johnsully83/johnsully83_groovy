package com.home.service.primes

import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults
import org.springframework.stereotype.Service

import com.home.dao.MongoDao
import com.home.events.prime.simple.SimplePrimeFinder
import com.home.model.cloud.mongo.MongoPrime
import com.home.model.enumeration.mongo.MapReduceFunctions
import com.home.model.wrapper.mapreduce.implementations.RoguePrime

@Service("primeFixer")
class PrimeFixer {
	private final Logger log = Logger.getLogger(SimplePrimeFinder.class);

	@Autowired @Qualifier("primeMongoDao")
	private MongoDao<MongoPrime, Integer> primeMongoDao;
	
	public void fix() {
		List<MongoPrime> firstPrime = primeMongoDao.query(1);
		
		if(firstPrime == null) {
			log.info("Not fixing primes because there aren't any.");
			return;
		}
		
		Integer	firstPrimeID = firstPrime.get(0).getId()-1;
		
		Map<String, Object> scopeVariables = new LinkedHashMap<String, Object>();
		scopeVariables.put("lastPrimeID", firstPrimeID);
		
		MapReduceOptions options = new MapReduceOptions();
		
		options.scopeVariables(scopeVariables).outputTypeInline().outputCollection(null);
		
		MapReduceResults<RoguePrime> results = primeMongoDao.mapReduce(MapReduceFunctions.PRIME_CLEANING, options, RoguePrime.class);
	
		for(RoguePrime roguePrime : results) {
			log.info("roguePrime: "+roguePrime.toString());
		}
		
		log.info("Done fixing primes!");
	}

}
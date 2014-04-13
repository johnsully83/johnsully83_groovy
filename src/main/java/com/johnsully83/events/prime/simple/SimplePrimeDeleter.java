package com.johnsully83.events.prime.simple;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.johnsully83.dao.MongoDao;
import com.johnsully83.events.prime.PrimeDeleter;
import com.johnsully83.model.cloud.mongo.MongoPrime;

@Service("primeDeleter")
public class SimplePrimeDeleter implements PrimeDeleter {
	
	private final Logger log = Logger.getLogger(getClass());

	private final MongoDao<MongoPrime, Integer> primeMongoDao;
	
	@Autowired
	public SimplePrimeDeleter(@Qualifier("primeMongoDao") MongoDao<MongoPrime, Integer> primeMongoDao) {
		super();
		this.primeMongoDao=primeMongoDao;
	}

	@Override
	public void delete() {
		Long count = primeMongoDao.count();

		log.info("\nCOUNT = "+count+"\n");
		
		while(count > 100000) {
			primeMongoDao.remove(10000);
			count = primeMongoDao.count();
			log.info("\nCOUNT = "+count+"\n");
		}
	}

}

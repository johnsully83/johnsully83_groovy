package com.johnsully83.service.thread.primes;

import org.apache.log4j.Logger

import com.johnsully83.dao.MongoDao
import com.johnsully83.dao.mongo.InstanceMongoDao
import com.johnsully83.model.cloud.mongo.MongoPrime

class MongoPrimeBatchSaveThread implements Runnable {
	private final Logger log = Logger.getLogger(MongoPrimeBatchSaveThread.class);

	private final MongoDao<MongoPrime, Integer> primeMongoDao;
	private final List<BigInteger> primesToSave;
	private final Integer firstNextID;
	
	public MongoPrimeBatchSaveThread(List<BigInteger> primesToSave, Integer nextID, 
			MongoDao<MongoPrime, Integer> primeMongoDao = new InstanceMongoDao(entityClass: MongoPrime.class, collectionName: "Prime")) {
		super();
		this.primeMongoDao = primeMongoDao;
		this.primesToSave = primesToSave;
		this.firstNextID = nextID;
	}
	
	@Override
	public void run() {
		log.info("Beginning merging of prime batch: primes #"+firstNextID+" to #"+(firstNextID+primesToSave.size()-1));
		def primeBatchs = primesToSave.collate(50);
		
		int nextOffset = 0;
		
		primeBatchs.each { primeBatch ->
			primeBatch.each { prime ->
				primeMongoDao.merge(new MongoPrime(firstNextID+nextOffset++, prime));
			}
		}
	}
}


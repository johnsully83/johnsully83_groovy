package com.home.service.thread.primes;

import org.apache.log4j.Logger

import com.home.dao.MongoDao
import com.home.dao.mongo.InstanceMongoDao
import com.home.model.cloud.mongo.MongoPrime

class MongoPrimeBatchSaveThread implements Runnable {
	private final Logger log = Logger.getLogger(MongoPrimeBatchSaveThread.class);

	private final MongoDao<MongoPrime, Integer> primeMongoDao;
	private final List<BigInteger> primesToSave;
	private final Integer firstNextID;
	
	public MongoPrimeBatchSaveThread(List<BigInteger> primesToSave, Integer nextID) {
		super();
		this.primeMongoDao = new InstanceMongoDao(MongoPrime.class);
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


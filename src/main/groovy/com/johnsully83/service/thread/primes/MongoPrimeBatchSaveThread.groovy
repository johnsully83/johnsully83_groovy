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
		def primeBatchs = primesToSave.collate(20);
		
		int nextOffset = 0;
		
		primeBatchs.each { primeBatch ->
			primeBatch.each { prime ->
				int index = firstNextID + nextOffset++;
				
				try {
					merge(new MongoPrime(index, prime), true);
				} catch(Exception e) {
					log.error("Error merging prime #${index} value ${prime}", e)
				}
			}
		}
	}
	
	def merge = { MongoPrime prime, Boolean retry ->
		try {
			primeMongoDao.merge(prime);
		} catch(Exception e) {
			if(retry) {
				merge(prime, false);
			}
			
			throw e;
		}
	}
	
}


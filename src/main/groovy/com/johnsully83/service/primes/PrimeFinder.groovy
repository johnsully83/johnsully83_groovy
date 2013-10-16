package com.johnsully83.service.primes

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

import com.johnsully83.dao.MongoDao
import com.johnsully83.exception.primes.TestingPrimeHasDivisorException
import com.johnsully83.model.cloud.mongo.MongoPrime
import com.johnsully83.service.thread.primes.MongoPrimeBatchSaveThread

@Service("primeFinder")
class PrimeFinder {
	private final Logger log = Logger.getLogger(PrimeFinder.class);
	
	@Autowired @Qualifier("primeMongoDao")
	private MongoDao<MongoPrime, Integer> primeMongoDao;
	
	public void find() {
		log.info("Beginning prime finding...");
		def prime;

		def primeResults = primeMongoDao.query(null, new Sort(Sort.Direction.DESC, "_id"), 1);

		if(primeResults.isEmpty()) {
			primeMongoDao.merge(new MongoPrime(1, 2G));
			primeMongoDao.merge(new MongoPrime(2, 3G));
			primeMongoDao.merge(new MongoPrime(3, 5G));
			prime = primeMongoDao.merge(new MongoPrime(4, 7G));
		} else {
			prime = primeResults.get(0);
		}

		while(true) {
			def nextPrimes = getNextPrimes(prime);

			def nextID = ++(prime.getId());

			executeMongoSave(new MongoPrimeBatchSaveThread(nextPrimes, nextID));

			def lastPrimeIndex = nextPrimes.size()-1;
			def primeValue = nextPrimes.get(lastPrimeIndex);

			prime = new MongoPrime(nextID+lastPrimeIndex, primeValue);
		}
	}

	private List<BigInteger> getNextPrimes(MongoPrime mongoPrime) {
		def prime = mongoPrime.getPrime();
		def nextPrimes = [];

		def allTests = (prime+1G)..(prime+10001G);

		allTests = allTests.grep {
			it % 2G == 1G;
		}.grep {
			it % 3G > 0;
		}.grep {
			it % 5G > 0;
		}.grep {
			it % 7G > 0;
		};

		allTests.collect {
			def sqrt = Math.ceil(Math.sqrt(it.doubleValue())).toBigInteger();

			def toCheck = it;

			def allPossibleDivisors = 2G..sqrt;

			try {
				allPossibleDivisors.collect {
					if(toCheck % it == 0G) {
						throw new TestingPrimeHasDivisorException();
					}
				}
			} catch(def e) {
				return;
			}

			nextPrimes.add(it);
		};

		return nextPrimes.sort();
	}

	private void executeMongoSave(MongoPrimeBatchSaveThread thread) {
		ExecutorService threadPool = Executors.newFixedThreadPool(50);
		
		threadPool.execute(thread);
	}

}

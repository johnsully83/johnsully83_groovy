package com.johnsully83.dao.mongo;

import java.util.List;

import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

import com.johnsully83.AppContext
import com.johnsully83.dao.MongoDao
import com.johnsully83.model.cloud.MongoCloudTable
import com.johnsully83.model.enumeration.mongo.MapReduceFunctions;

class InstanceMongoDao<PK extends Comparable<PK>, T extends MongoCloudTable<PK>> implements MongoDao<T, PK> {
	
	private MongoOperations mongoOperations;
	
	private final Class<T> entityClass;
	private final String collectionName;

	InstanceMongoDao(Class<T> entityClass, String collectionName) {
		super();
		this.mongoOperations = AppContext.getApplicationContext().getBean("mongoTemplate", MongoOperations.class);
		this.entityClass = entityClass;
		this.collectionName = collectionName;
	}

	@Override
	public void add(T record) {
		checkCollectionExists();
		
		mongoOperations.insert(record);
	}

	@Override
	public void addAll(List<T> records) {
		checkCollectionExists();
		
		mongoOperations.insertAll(records);
	}

	@Override
	public T merge(T record) {
		checkCollectionExists();
		
		mongoOperations.save(record);
		List<T> results = mongoOperations.find(new Query(Criteria.where("_id").is(record.getId())), entityClass);
		
		return results.get(0);
	}

	@Override
	public void remove(T record) {
		checkCollectionExists();
		
		mongoOperations.remove(record);
	}

	@Override
	public T findByID(PK id) {
		checkCollectionExists();
		
		return mongoOperations.findById(id, entityClass);
	}

	@Override
	public T find(PK key) {
		checkCollectionExists();
		
		return mongoOperations.findOne(new Query(Criteria.where("_id").is(key)), entityClass);
	}

	@Override
	public List<T> findAll() {
		checkCollectionExists();
		
		return mongoOperations.findAll(entityClass);
	}

	@Override
	public List<T> query(Sort sort) {
		return query(null, sort, null);
	}
	
	@Override
	public List<T> query(Integer limit) {
		return query(null, null, limit);
	}

	@Override
	public List<T> query(Criteria criteria) {
		return query(criteria, null, null);
	}
	
	@Override
	public List<T> query(Criteria criteria, Sort sort) {
		return query(criteria, sort, null);
	}
	
	@Override
	public List<T> query(Criteria criteria, Sort sort, Integer limit) {
		if(criteria == null) {
			criteria = new Criteria();
		}
		
		if(sort == null) {
			sort = new Sort(Sort.Direction.ASC, "_id");
		}
		
		if(limit == null) {
			return query(new Query(criteria).with(sort));
		} else {
			return query(new Query(criteria).with(sort).limit(limit));
		}
	}

	@Override
	public List<T> query(Query query) {
		checkCollectionExists();
		
		return mongoOperations.find(query, entityClass);
	}

	@Override
	public <W> MapReduceResults<W> mapReduce(Query query, MapReduceFunctions functions, MapReduceOptions options, Class<W> resultClass) {
		checkCollectionExists();
		
		if(query == null) {
			query = new Query().with(new Sort(Sort.Direction.ASC, "_id"));
		}
		
		if(options == null) {
			options = new MapReduceOptions();
		}
		
		return mongoOperations.mapReduce(query, collectionName, functions.mapFunction(), functions.reduceFunction(), options, resultClass);
	}

	@Override
	public MapReduceResults<T> mapReduce(MapReduceFunctions functions) {
		return mapReduce(null, functions, null, entityClass);
	}

	@Override
	public MapReduceResults<T> mapReduce(MapReduceFunctions functions, Query query) {
		return mapReduce(query, functions, null, entityClass);
	}

	@Override
	public MapReduceResults<T> mapReduce(MapReduceFunctions functions, MapReduceOptions options) {
		return mapReduce(null, functions, options, entityClass);
	}

	@Override
	public MapReduceResults<T> mapReduce(MapReduceFunctions functions, Query query, MapReduceOptions options) {
		return mapReduce(query, functions, options, entityClass);
	}

	@Override
	public <W> MapReduceResults<W> mapReduce(MapReduceFunctions functions, Query query, Class<W> resultClass) {
		return mapReduce(query, functions, null, resultClass);
	}

	@Override
	public <W> MapReduceResults<W> mapReduce(MapReduceFunctions functions, MapReduceOptions options, Class<W> resultClass) {
		return mapReduce(null, functions, options, resultClass);
	}

	@Override
	public <W> MapReduceResults<W> mapReduce(MapReduceFunctions functions, Query query, MapReduceOptions options, Class<W> resultClass) {
		return mapReduce(query, functions, options, resultClass);
	}

	private void checkCollectionExists() {
		if(!mongoOperations.collectionExists(entityClass)) {
			mongoOperations.createCollection(entityClass);
		}
	}

}

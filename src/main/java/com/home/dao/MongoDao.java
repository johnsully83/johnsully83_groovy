package com.home.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.home.model.cloud.MongoCloudTable;
import com.home.model.enumeration.mongo.MapReduceFunctions;

public interface MongoDao<T extends MongoCloudTable<PK>, PK extends Comparable<PK>> {
	
	public void add(T record);
	
	public void addAll(List<T> records);
	
	public T merge(T record);
	
	public void remove(T record);
	
	public T findByID(PK id);
	
	public T find(PK key);

	public List<T> findAll();
	
	public List<T> query(Sort sort);
	
	public List<T> query(Integer limit);
	
	public List<T> query(Criteria criteria);
	
	public List<T> query(Criteria criteria, Sort sort);

	public List<T> query(Criteria criteria, Sort sort, Integer limit);

	public List<T> query(Query query);

	public <W> MapReduceResults<W> mapReduce(Query query, MapReduceFunctions functions,
			MapReduceOptions options, Class<W> resultClass);

	public MapReduceResults<T> mapReduce(MapReduceFunctions functions);

	public MapReduceResults<T> mapReduce(MapReduceFunctions functions, Query query);

	public MapReduceResults<T> mapReduce(MapReduceFunctions functions,
			MapReduceOptions options);

	public MapReduceResults<T> mapReduce(MapReduceFunctions functions, Query query,
			MapReduceOptions options);

	public <W> MapReduceResults<W> mapReduce(MapReduceFunctions functions, Query query,
			Class<W> resultClass);
	
	public <W> MapReduceResults<W> mapReduce(MapReduceFunctions functions,
			MapReduceOptions options, Class<W> resultClass);

	public <W> MapReduceResults<W> mapReduce(MapReduceFunctions functions, Query query,
			MapReduceOptions options, Class<W> resultClass);

}

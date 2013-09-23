package com.home.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.home.model.cloud.CloudTable;

public interface JpaDao<T extends CloudTable<PK>, PK extends Comparable<PK>> {
	
	public void add(T record);
	
	public T merge(T record);
	
	public void delete(T record);
	
	public void remove(T record);
	
	public T find(PK key);
	
	public T findOne(String where, String orderBy) throws EntityNotFoundException;

	public List<T> findAll();

	public List<T> findAll(String orderBy);
	
	public List<T> query(String whereClause);

	public List<T> query(String where, String orderBy);
	
}

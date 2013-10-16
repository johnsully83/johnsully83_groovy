package com.johnsully83.service.model;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.johnsully83.model.cloud.CloudTable;

public interface DtoService<T extends CloudTable<PK>, PK extends Comparable<PK>> {

	public void add(T entity);
	
	public T find(PK pk);

	public T findOne(String where, String orderBy) throws EntityNotFoundException;

	public List<T> findAll();

	public List<T> findAll(String orderBy);
	
	public List<T> query(String where);
	
	public List<T> query(String where, String orderBy);
	
	public T merge(T entity);

	public void delete(T entity);
	
	public void delete(PK pk);
	
	public void remove(T entity);
	
	public void remove(PK pk);

}

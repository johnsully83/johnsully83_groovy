package com.johnsully83.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.johnsully83.dao.JpaDao;
import com.johnsully83.model.cloud.CloudTable;

public class SimpleJpaDao<T extends CloudTable<PK>, PK extends Comparable<PK>> implements JpaDao<T, PK> {
	
	private final Class<T> type;
	
	public SimpleJpaDao(Class<T> type) {
		super();
		this.type=type;
	}
	
	@PersistenceContext(unitName="persistenceUnitCloudbees")
	private EntityManager entityManager;

	@Override
	public void add(T record) {
		entityManager.persist(record);
	}

	@Override
	public T merge(T record) {
		return entityManager.merge(record);
	}

	@Override
	public void delete(T record) {
		record.setIsDeleted(true);
		entityManager.merge(record);
	}

	@Override
	public void remove(T record) {
		try {
			entityManager.remove(record);
		} catch (IllegalArgumentException e) {
			throw new EntityNotFoundException("Entity does not exist. Unable to delete.");
		}
	}

	@Override
	public T find(PK key) {
		return entityManager.find(type, key);
	}

	@Override
	public T findOne(String where, String orderBy) throws EntityNotFoundException {
		String queryString = "SELECT a FROM "+type.getName()+" a WHERE "+where+" ORDER BY "+orderBy;
		TypedQuery<T> query = entityManager.createQuery(queryString, type);
		query.setMaxResults(1);
		
		List<T> results = query.getResultList();
		
		if(results.isEmpty()) {
			throw new EntityNotFoundException("Could not find entity WHERE "+where);
		} else {
			return results.get(0);
		}
	}

	@Override
	public List<T> findAll() {
		String queryString = "SELECT a FROM "+type.getName()+" a WHERE 1=1";
		TypedQuery<T> query = entityManager.createQuery(queryString, type);
		
		return query.getResultList();
	}

	@Override
	public List<T> findAll(String orderBy) {
		String queryString = "SELECT a FROM "+type.getName()+" a WHERE 1=1 ORDER BY "+orderBy;
		TypedQuery<T> query = entityManager.createQuery(queryString, type);
		
		return query.getResultList();
	}

	@Override
	public List<T> query(String whereClause) {
		String queryString = "SELECT a FROM "+type.getName()+" a WHERE "+whereClause;
		TypedQuery<T> query = entityManager.createQuery(queryString, type);

		return query.getResultList();
	}

	@Override
	public List<T> query(String where, String orderBy) {
		String queryString = "SELECT a FROM "+type.getName()+" a WHERE "+where + " ORDER BY "+orderBy;
		TypedQuery<T> query = entityManager.createQuery(queryString, type);

		return query.getResultList();
	}

}

package com.johnsully83.service.model;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.transaction.annotation.Transactional;

import com.johnsully83.dao.JpaDao;
import com.johnsully83.model.cloud.CloudTable;

public class AbstractDtoService<T extends CloudTable<PK>, PK extends Comparable<PK>> implements DtoService<T, PK> {
	private final JpaDao<T, PK> cloudTableDao;
	
	protected AbstractDtoService(JpaDao<T, PK> cloudTableDao) {
		super();
		this.cloudTableDao=cloudTableDao;
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public void add(T entity) {
		cloudTableDao.add(entity);
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public T find(PK pk) {
		return cloudTableDao.find(pk);
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public T findOne(String where, String orderBy) throws EntityNotFoundException {
		return cloudTableDao.findOne(where, orderBy);
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public List<T> findAll() {
		return cloudTableDao.findAll();
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public List<T> findAll(String orderBy) {
		return cloudTableDao.findAll(orderBy);
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public T merge(T entity) {
		return cloudTableDao.merge(entity);
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public void delete(T entity) {
		cloudTableDao.delete(entity);
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public void delete(PK pk) {
		cloudTableDao.delete(cloudTableDao.find(pk));
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public void remove(T entity) {
		cloudTableDao.remove(entity);
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public void remove(PK pk) {
		cloudTableDao.remove(cloudTableDao.find(pk));
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public List<T> query(String where) {
		return cloudTableDao.query(where);
	}

	@Override
	@Transactional(readOnly=false, value="transactionManagerCloudbees")
	public List<T> query(String where, String orderBy) {
		return cloudTableDao.query(where, orderBy);
	}
	
	protected JpaDao<T, PK> getCloudTableDao() {
		return this.cloudTableDao;
	}
	
}
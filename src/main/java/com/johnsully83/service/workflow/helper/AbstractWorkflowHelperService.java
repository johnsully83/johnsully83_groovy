package com.johnsully83.service.workflow.helper;

import java.util.List;

import com.johnsully83.model.cloud.CloudTable;
import com.johnsully83.service.model.DtoService;
import com.johnsully83.service.workflow.WorkflowHelperService;

public abstract class AbstractWorkflowHelperService<T extends CloudTable<PK>, PK extends Comparable<PK>> implements
		WorkflowHelperService<T, PK> {
	
	private final DtoService<T, PK> dtoService;
	
	protected AbstractWorkflowHelperService(DtoService<T, PK> dtoService) {
		super();
		this.dtoService=dtoService;
	}
	
	protected void add(T entity) {
		getDtoService().add(entity);
	}

	protected T find(PK pk) {
		return getDtoService().find(pk);
	}

	protected List<T> findAll() {
		return getDtoService().findAll();
	}
	
	protected List<T> query(String where) {
		return getDtoService().query(where);
	}
	
	protected T merge(T entity) {
		return getDtoService().merge(entity);
	}

	protected void delete(T entity) {
		getDtoService().delete(entity);
	}
	
	protected void delete(PK pk) {
		getDtoService().delete(pk);
	}
	
	protected void remove(T entity) {
		getDtoService().remove(entity);
	}
	
	protected void remove(PK pk) {
		getDtoService().remove(pk);
	}

	private DtoService<T, PK> getDtoService() {
		return dtoService;
	}

}

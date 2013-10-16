package com.johnsully83.service.propertyEditor;

import java.beans.PropertyEditorSupport;

import com.johnsully83.dao.implementations.SimpleJpaDao;
import com.johnsully83.model.cloud.CloudTable;

public abstract class DtoPropertyEditor<T extends CloudTable<PK>, PK extends Comparable<PK>> extends PropertyEditorSupport  {
	
	private final SimpleJpaDao<T, PK> cloudTableDao;
	
	protected DtoPropertyEditor(SimpleJpaDao<T, PK> cloudTableDao) {
		super();
		this.cloudTableDao=cloudTableDao;
	}

	protected SimpleJpaDao<T, PK> getCloudTableDao() {
		return cloudTableDao;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public String getAsText() {  
		return getDisplayValue((T) getValue());
	}
	
	@Override
	public void setAsText(String value) {  
		setValue(cloudTableDao.find(parsePrimaryKey(value)));
	}
	
	protected abstract String getDisplayValue(T entity);
	
	protected abstract PK parsePrimaryKey(String value);
	
}

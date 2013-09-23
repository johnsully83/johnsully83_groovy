package com.home.service.workflow;

import java.util.List;

import com.home.model.cloud.CloudTable;

public interface WorkflowHelperWrapper<T extends CloudTable<PK>, PK extends Comparable<PK>> {
	
	public List<T> getAllEntities();
	
}

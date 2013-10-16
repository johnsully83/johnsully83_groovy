package com.johnsully83.service.workflow;

import java.util.List;

import com.johnsully83.model.cloud.CloudTable;

public interface WorkflowHelperWrapper<T extends CloudTable<PK>, PK extends Comparable<PK>> {
	
	public List<T> getAllEntities();
	
}

package com.johnsully83.service.workflow.helper;

import java.util.List;

import com.johnsully83.model.cloud.CloudTable;
import com.johnsully83.service.workflow.WorkflowHelperWrapper;

public abstract class AbstractWorkflowHelperWrapper<T extends CloudTable<PK>, PK extends Comparable<PK>>
		implements WorkflowHelperWrapper<T, PK> {
	
	@Override
	public abstract List<T> getAllEntities();

}

package com.home.service.workflow.helper;

import java.util.List;

import com.home.model.cloud.CloudTable;
import com.home.service.workflow.WorkflowHelperWrapper;

public abstract class AbstractWorkflowHelperWrapper<T extends CloudTable<PK>, PK extends Comparable<PK>>
		implements WorkflowHelperWrapper<T, PK> {
	
	@Override
	public abstract List<T> getAllEntities();

}

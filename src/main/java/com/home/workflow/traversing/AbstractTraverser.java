package com.home.workflow.traversing;

import com.home.model.cloud.CloudTable;
import com.home.service.workflow.WorkflowHelperService;
import com.home.service.workflow.WorkflowHelperWrapper;


public abstract class AbstractTraverser<W extends WorkflowHelperService<T, PK>, H extends WorkflowHelperWrapper<T, PK>,
	T extends CloudTable<PK>, PK extends Comparable<PK>> implements
		Traverser {
	protected final W workflowHelperService;
	protected final H workflowHelperWrapper;
	
	protected AbstractTraverser(W workflowHelperService, H workflowHelperWrapper) {
		super();
		this.workflowHelperService=workflowHelperService;
		this.workflowHelperWrapper=workflowHelperWrapper;
	}
	
	public W getWorkflowHelperService() {
		return this.workflowHelperService;
	}
	
	public H getWorkflowHelperWrapper() {
		return this.workflowHelperWrapper;
	}
	
}

package com.home.events.replication;

import com.home.model.cloud.CloudTable;
import com.home.workflow.node.Node;
import com.home.workflow.traversing.Traverser;

public abstract class AbstractReplicator<R extends Traverser, T extends CloudTable<PK>, PK extends Comparable<PK>>
		implements Replicator<T, PK> {
	private final Node<R> startNode;
	
	protected AbstractReplicator(Node<R> startNode) {
		super();
		this.startNode=startNode;
	}

	@Override
	public abstract void replicate();
	
	protected Node<R> getStartNode() {
		return startNode;
	}

}

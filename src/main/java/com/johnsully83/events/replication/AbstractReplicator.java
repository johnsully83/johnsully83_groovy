package com.johnsully83.events.replication;

import com.johnsully83.model.cloud.CloudTable;
import com.johnsully83.workflow.node.Node;
import com.johnsully83.workflow.traversing.Traverser;

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

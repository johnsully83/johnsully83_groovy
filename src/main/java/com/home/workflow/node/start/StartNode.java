package com.home.workflow.node.start;

import org.apache.log4j.Logger;

import com.home.workflow.node.Node;
import com.home.workflow.traversing.Traverser;

/**
 * @author Sully
 */
public class StartNode<T extends Traverser> implements Node<T> {

	private final Logger log = Logger.getLogger(StartNode.class);
	protected Node<T> nextNode;

	public StartNode() {
		super();
	}

	@Override
	public final void start(T traverser) {
		next(traverser);
	}

	protected final void next(T traverser) {
		nextNode.start(traverser);
	}

	@Override
	public void dropOut(String dropOutReason) {
		log.error("Drop out:" + dropOutReason);
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public void dropOut(String message, Exception exception) {
		log.error(message, exception);
	}

}

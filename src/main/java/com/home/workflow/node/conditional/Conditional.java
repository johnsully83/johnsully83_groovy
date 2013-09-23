package com.home.workflow.node.conditional;

import org.apache.log4j.Logger;

import com.home.workflow.node.Node;
import com.home.workflow.traversing.Traverser;

public abstract class Conditional<T extends Traverser> implements Node<T> {
	private final Logger log = Logger.getLogger(Conditional.class);

	protected Node<T> yesNode;
	protected Node<T> noNode;

	public Conditional() {
	}

	@Override
	public final void start(T traverser) {
		evaluate(traverser);
	}

	protected abstract void evaluate(T tasks);

	protected final void yes(T traverser) {
		yesNode.start(traverser);
	}

	protected final void no(T traverser) {
		noNode.start(traverser);
	}

	public void setYesNode(Node<T> yesNode) {
		this.yesNode = yesNode;
	}

	public void setNoNode(Node<T> noNode) {
		this.noNode = noNode;
	}

	@Override
	public void dropOut(String message) {
		log.error(message);
	}

	@Override
	public void dropOut(String message, Exception exception) {
		log.error(message, exception);
	}

}

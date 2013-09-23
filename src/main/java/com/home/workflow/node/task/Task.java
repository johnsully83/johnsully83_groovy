package com.home.workflow.node.task;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.home.AppContext;
import com.home.workflow.node.Node;
import com.home.workflow.traversing.Traverser;

public abstract class Task<T extends Traverser> implements Node<T> {
	private final Logger log = Logger.getLogger(Task.class);

	protected Node<T> nextNode;
	protected ApplicationContext applicationContext;

	public Task() {
		super();
	}

	@Override
	public final void start(T traverser) {
		this.applicationContext = AppContext.getApplicationContext();

		handle(traverser);
		next(traverser);
	}

	protected abstract void handle(T tasks);

	private final void next(T traverser) {
		nextNode.start(traverser);
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
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

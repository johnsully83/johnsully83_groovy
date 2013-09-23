package com.home.workflow.node.end;

import org.apache.log4j.Logger;

import com.home.workflow.node.Node;
import com.home.workflow.traversing.Traverser;

/**
 * @author Sully
 */
public class EndNode<T extends Traverser> implements Node<T> {

	private final Logger log = Logger.getLogger(EndNode.class);
	
	public EndNode() {
		super();
	}

	@Override
	public void start(T tasks) {
		end(tasks);
	}

	public void end(T tasks) {
	}

	@Override
	public void dropOut(String dropOutReason) {
		log.error("Drop out:" + dropOutReason);	
	}

	@Override
	public void dropOut(String message, Exception exception) {
		log.error(message, exception);
	}
}

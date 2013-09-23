package com.home.workflow.node;

import com.home.workflow.traversing.Traverser;

public interface Node<T extends Traverser> {
	
    public void start(T traverser);
	
	public void dropOut(String message);
	
	public void dropOut(String message, Exception exception);
	
}

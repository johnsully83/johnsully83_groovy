package com.johnsully83.workflow.node;

import com.johnsully83.workflow.traversing.Traverser;

public interface Node<T extends Traverser> {
	
    public void start(T traverser);
	
	public void dropOut(String message);
	
	public void dropOut(String message, Exception exception);
	
}

package com.home.events.replication.state;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.home.events.replication.AbstractReplicator;
import com.home.model.cloud.jpa.State;
import com.home.workflow.node.Node;
import com.home.workflow.traversing.implementations.StateTraverser;

@Service("stateReplicator")
public class StateReplicator extends AbstractReplicator<StateTraverser, State, Integer> {
	private final Logger log = Logger.getLogger(StateReplicator.class);	
	
	@Autowired
	public StateReplicator(@Qualifier("stateReplicationWorkflow") Node<StateTraverser> startNode) {
		super(startNode);
	}

	@Override
	public void replicate() {
		log.info("Beginning state replication...");
		
		getStartNode().start(new StateTraverser());
		
		log.info("Ending state replication...");
	}

}

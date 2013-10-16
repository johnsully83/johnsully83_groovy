package com.johnsully83.events.replication.state;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.johnsully83.events.replication.AbstractReplicator;
import com.johnsully83.model.cloud.jpa.State;
import com.johnsully83.workflow.node.Node;
import com.johnsully83.workflow.traversing.implementations.StateTraverser;

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

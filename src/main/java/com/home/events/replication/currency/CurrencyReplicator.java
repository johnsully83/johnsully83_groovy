package com.home.events.replication.currency;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.home.events.replication.AbstractReplicator;
import com.home.model.cloud.jpa.LatestRates;
import com.home.workflow.node.Node;
import com.home.workflow.traversing.implementations.CurrencyTraverser;

@Service("currencyReplicator")
public class CurrencyReplicator extends AbstractReplicator<CurrencyTraverser, LatestRates, Integer> {
	private final Logger log = Logger.getLogger(CurrencyReplicator.class);	

	@Autowired
	public CurrencyReplicator(@Qualifier("currenyReplicationWorkflow") Node<CurrencyTraverser> startNode) {
		super(startNode);
	}

	@Override
	public void replicate() {
		log.info("Beginning currency replication...");
		
		getStartNode().start(new CurrencyTraverser());
		
		log.info("Ending currency replication...");
	}

}

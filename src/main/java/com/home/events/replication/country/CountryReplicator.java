package com.home.events.replication.country;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.home.events.replication.AbstractReplicator;
import com.home.model.cloud.jpa.Country;
import com.home.workflow.node.Node;
import com.home.workflow.traversing.implementations.CountryTraverser;

@Service("countryReplicator")
public class CountryReplicator extends AbstractReplicator<CountryTraverser, Country, Integer> {
	private final Logger log = Logger.getLogger(CountryReplicator.class);

	@Autowired
	public CountryReplicator(@Qualifier("countryReplicationWorkflow") Node<CountryTraverser> startNode) {
		super(startNode);
	}

	@Override
	public void replicate() {
		log.info("Beginning country replication...");
		
		getStartNode().start(new CountryTraverser());
		
		log.info("Ending country replication...");
	}

}

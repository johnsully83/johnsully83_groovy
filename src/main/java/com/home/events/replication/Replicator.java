package com.home.events.replication;

import com.home.model.cloud.CloudTable;

public interface Replicator<T extends CloudTable<PK>, PK extends Comparable<PK>> {

	public void replicate();
	
}

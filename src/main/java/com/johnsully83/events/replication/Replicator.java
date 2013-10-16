package com.johnsully83.events.replication;

import com.johnsully83.model.cloud.CloudTable;

public interface Replicator<T extends CloudTable<PK>, PK extends Comparable<PK>> {

	public void replicate();
	
}

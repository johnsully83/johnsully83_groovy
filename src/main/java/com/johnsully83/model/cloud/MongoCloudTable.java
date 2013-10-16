package com.johnsully83.model.cloud;

import java.io.Serializable;


public interface MongoCloudTable<PK extends Comparable<PK>> extends Serializable {

	public Integer getId();
	
	public void setId(Integer id);
	
}

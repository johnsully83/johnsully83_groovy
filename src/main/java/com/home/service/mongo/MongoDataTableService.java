package com.home.service.mongo;

import org.json.JSONObject;

import com.home.model.cloud.MongoCloudTable;
import com.home.model.datatable.JQueryDataTableParameter;

public interface MongoDataTableService<T extends MongoCloudTable<PK>, PK extends Comparable<PK>> {
	
	public JSONObject getData(JQueryDataTableParameter parameters);

}

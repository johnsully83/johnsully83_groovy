package com.johnsully83.service.mongo;

import org.json.JSONObject;

import com.johnsully83.model.cloud.MongoCloudTable;
import com.johnsully83.model.datatable.JQueryDataTableParameter;

public interface MongoDataTableService<T extends MongoCloudTable<PK>, PK extends Comparable<PK>> {
	
	public JSONObject getData(JQueryDataTableParameter parameters);

}

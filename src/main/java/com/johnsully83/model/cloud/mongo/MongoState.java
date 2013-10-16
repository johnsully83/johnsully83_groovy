package com.johnsully83.model.cloud.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.johnsully83.model.cloud.MongoCloudTable;

@Document(collection="MongoState")
public class MongoState implements MongoCloudTable<Integer> {
	private static final long serialVersionUID = 2407198280897293888L;

	@Id
	private Integer id;

	@Indexed(unique=true)
	private String name;
	@DBRef
	@Indexed
	private MongoCountry country;
	
	public MongoState() {
		super();
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MongoCountry getCountry() {
		return country;
	}

	public void setCountry(MongoCountry country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("State [");
		builder.append("id="+id+", ");
		builder.append("name="+name+", ");
		builder.append("country="+country);
		builder.append("]");
		
		return builder.toString();
	}

}

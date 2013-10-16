package com.johnsully83.model.cloud.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.johnsully83.model.cloud.MongoCloudTable;

@Document(collection="MongoCity")
public class MongoCity implements MongoCloudTable<Integer> {
	private static final long serialVersionUID = 2791988850037856989L;

	@Id
	@Indexed(unique=true)
	private Integer id;

	@Indexed(unique=true)
	private String name;
	@DBRef
	@Indexed
	private MongoCountry country;
	@DBRef
	@Indexed
	private MongoState state;
	
	public MongoCity() {
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

	public MongoState getState() {
		return state;
	}

	public void setState(MongoState state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MongoCity other = (MongoCity) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("City [");
		builder.append("id="+id+", ");
		builder.append("name="+name+", ");
		builder.append("country="+country);
		builder.append("state="+state);
		builder.append("]");
		
		return builder.toString();
	}

}

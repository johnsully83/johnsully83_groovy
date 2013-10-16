package com.johnsully83.model.cloud.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.johnsully83.model.cloud.MongoCloudTable;

@Document(collection="MongoCountry")
public class MongoCountry implements MongoCloudTable<Integer> {
	private static final long serialVersionUID = 2805152574282976239L;

	@Id
	private Integer id;

	@Indexed(unique=true)
	private String name;
	private Boolean hasStates=true;
	
	public MongoCountry() {
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

	public Boolean getHasStates() {
		return hasStates;
	}

	public void setHasStates(Boolean hasStates) {
		this.hasStates = hasStates;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hasStates == null) ? 0 : hasStates.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		MongoCountry other = (MongoCountry) obj;
		if (hasStates == null) {
			if (other.hasStates != null)
				return false;
		} else if (!hasStates.equals(other.hasStates))
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
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Country [");
		builder.append("id="+id+", ");
		builder.append("name="+name+", ");
		builder.append("hasStates="+hasStates);
		builder.append("]");
		
		return builder.toString();
	}

}

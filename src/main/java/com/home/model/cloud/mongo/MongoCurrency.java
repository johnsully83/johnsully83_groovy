package com.home.model.cloud.mongo;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.home.model.cloud.MongoCloudTable;
import com.home.model.cloud.jpa.CurrencyValue;

@Document(collection="MongoCurrency")
public class MongoCurrency implements MongoCloudTable<Integer> {
	private static final long serialVersionUID = 8296104894507238797L;
	
	@Id
	private Integer id;

	@Indexed(unique=false)
	private String currencyCode;
	private BigDecimal value;
	@Indexed(unique=false)
	private Integer timestamp;
	
	public MongoCurrency() {
		super();
	}
	
	public MongoCurrency(Integer id, String currencyCode,
			BigDecimal value, Integer timestamp) {
		super();
		this.id = id;
		this.currencyCode = currencyCode;
		this.value = value;
		this.timestamp = timestamp;
	}

	public MongoCurrency(CurrencyValue currencyValue) {
		super();
		this.id=currencyValue.getPk();
		this.currencyCode=currencyValue.getCurrency().getCurrencyCode();
		this.value=currencyValue.getValue();
		this.timestamp=currencyValue.getLatestRates().getTimestamp();
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "MongoCurrency [id=" + id + ", currencyCode="
				+ currencyCode + ", value=" + value + ", timestamp="
				+ timestamp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		MongoCurrency other = (MongoCurrency) obj;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}

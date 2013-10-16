package com.johnsully83.model.cloud.jpa;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.johnsully83.model.cloud.CloudTable;

@Entity(name="CurrencyValue")
public class CurrencyValue implements CloudTable<Integer> {
	private static final long serialVersionUID = 3956420751756221336L;
	
	private Integer pk;
	private Date dateAdded = new Date();
	private Date dateLastModified = new Date();
	private Boolean isDeleted = false;
	
	private Currency currency;
	private LatestRates latestRates;
	private BigDecimal value;
	
	public CurrencyValue() {
		super();
	}
	
	public CurrencyValue(Currency currency, LatestRates latestRates, BigDecimal value) {
		super();
		this.currency=currency;
		this.latestRates=latestRates;
		this.value=value;
	}

	@Override
	@Id
	@Column(name="currencyValueID", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getPk() {
		return pk;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}

	@Column(name="dateAdded", nullable=false, updatable=false)
	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Column(name="dateLastModified", nullable=false)
	public Date getDateLastModified() {
		return dateLastModified;
	}

	public void setDateLastModified(Date dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	@Column(name="isDeleted", nullable=false)
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	public LatestRates getLatestRates() {
		return latestRates;
	}

	public void setLatestRates(LatestRates latestRates) {
		this.latestRates = latestRates;
	}

	@Column(name="value", nullable=false)
	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime
				* result
				+ ((dateLastModified == null) ? 0 : dateLastModified.hashCode());
		result = prime * result
				+ ((isDeleted == null) ? 0 : isDeleted.hashCode());
		result = prime * result
				+ ((latestRates == null) ? 0 : latestRates.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
		CurrencyValue other = (CurrencyValue) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (dateLastModified == null) {
			if (other.dateLastModified != null)
				return false;
		} else if (!dateLastModified.equals(other.dateLastModified))
			return false;
		if (isDeleted == null) {
			if (other.isDeleted != null)
				return false;
		} else if (!isDeleted.equals(other.isDeleted))
			return false;
		if (latestRates == null) {
			if (other.latestRates != null)
				return false;
		} else if (!latestRates.equals(other.latestRates))
			return false;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CurrencyValue [pk=" + pk + ", dateAdded=" + dateAdded
				+ ", dateLastModified=" + dateLastModified + ", isDeleted="
				+ isDeleted + ", currency=" + currency + ", latestRates="
				+ latestRates + ", value=" + value + "]";
	}

}

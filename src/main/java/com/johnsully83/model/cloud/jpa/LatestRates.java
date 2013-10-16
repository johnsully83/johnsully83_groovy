package com.johnsully83.model.cloud.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

import com.johnsully83.model.cloud.CloudTable;
import com.johnsully83.model.json.OpenExchangeLatestRates;

@Entity(name="LatestRates")
@Embeddable
public class LatestRates implements CloudTable<Integer> {
	private static final long serialVersionUID = 6916331105902409620L;
	
	private Integer pk;
	private Date dateAdded = new Date();
	private Date dateLastModified = new Date();
	private Boolean isDeleted = false;
	
	private String disclaimer;
	private String license;
	private Integer timestamp;
	private String base;
	
	public LatestRates() {
		super();
	}

	public LatestRates(OpenExchangeLatestRates openExchangeLatestRates) {
		super();
		this.disclaimer=openExchangeLatestRates.getDisclaimer();
		this.license=openExchangeLatestRates.getLicense();
		this.base=openExchangeLatestRates.getBase();
		this.timestamp=openExchangeLatestRates.getTimestamp();
	}

	@Override
	@Id
	@Column(name="latestRatesID", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getPk() {
		return pk;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}

	@Override
	@Column(name="dateAdded", nullable=false, updatable=false)
	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	@Column(name="dateLastModified", nullable=false)
	public Date getDateLastModified() {
		return dateLastModified;
	}

	public void setDateLastModified(Date dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	@Override
	@Column(name="isDeleted", nullable=false)
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name="disclaimer", length=8000)
	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	@Column(name="license", length=8000)
	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@NaturalId
	@Column(name="timestamp", nullable=false)
	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name="base", length=10)
	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base == null) ? 0 : base.hashCode());
		result = prime * result
				+ ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime
				* result
				+ ((dateLastModified == null) ? 0 : dateLastModified.hashCode());
		result = prime * result
				+ ((disclaimer == null) ? 0 : disclaimer.hashCode());
		result = prime * result
				+ ((isDeleted == null) ? 0 : isDeleted.hashCode());
		result = prime * result + ((license == null) ? 0 : license.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
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
		LatestRates other = (LatestRates) obj;
		if (base == null) {
			if (other.base != null)
				return false;
		} else if (!base.equals(other.base))
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
		if (disclaimer == null) {
			if (other.disclaimer != null)
				return false;
		} else if (!disclaimer.equals(other.disclaimer))
			return false;
		if (isDeleted == null) {
			if (other.isDeleted != null)
				return false;
		} else if (!isDeleted.equals(other.isDeleted))
			return false;
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LatestRates [pk=" + pk + ", dateAdded=" + dateAdded
				+ ", dateLastModified=" + dateLastModified + ", isDeleted="
				+ isDeleted + ", disclaimer=" + disclaimer + ", license="
				+ license + ", timestamp=" + timestamp + ", base=" + base + "]";
	}

}

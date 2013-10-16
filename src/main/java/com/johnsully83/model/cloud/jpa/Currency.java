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

@Entity(name="Currency")
@Embeddable
public class Currency implements CloudTable<Integer> {
	private static final long serialVersionUID = -1287234696223912088L;
	
	private Integer pk;
	private Date dateAdded = new Date();
	private Date dateLastModified = new Date();
	private Boolean isDeleted = false;
	
	private String currencyCode;
	private String name;

	public Currency() {
		super();
	}
	
	public Currency(String currencyCode, String name) {
		super();
		this.currencyCode=currencyCode;
		this.name=name;
	}

	@Override
	@Id
	@Column(name="currencyID", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getPk() {
		return pk;
	}

	@Override
	public void setPk(Integer pk) {
		this.pk = pk;
	}

	@Override
	@Column(name="dateAdded", nullable=false, updatable=false)
	public Date getDateAdded() {
		return dateAdded;
	}

	@Override
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	@Column(name="dateLastModified", nullable=false)
	public Date getDateLastModified() {
		return dateLastModified;
	}

	@Override
	public void setDateLastModified(Date dateLastModified) {
		this.dateLastModified = dateLastModified;
	}
	
	@Override
	@Column(name="isDeleted", nullable=false)
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	@Override
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@NaturalId
	@Column(name="currencyCode", nullable=false)
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Column(name="name", nullable=false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result
				+ ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime
				* result
				+ ((dateLastModified == null) ? 0 : dateLastModified.hashCode());
		result = prime * result
				+ ((isDeleted == null) ? 0 : isDeleted.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
		Currency other = (Currency) obj;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Currency [pk=" + pk + ", dateAdded=" + dateAdded
				+ ", dateLastModified=" + dateLastModified + ", isDeleted="
				+ isDeleted + ", currencyCode=" + currencyCode + ", name="
				+ name + "]";
	}

}

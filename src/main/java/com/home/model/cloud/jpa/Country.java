package com.home.model.cloud.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

import com.home.model.cloud.CloudTable;

@Entity(name="Country")
@Embeddable
public class Country implements CloudTable<Integer> {
	private static final long serialVersionUID = -7180816985267486780L;
	
	private Integer pk;
	private Date dateAdded = new Date();
	private Date dateLastModified = new Date();
	private Boolean isDeleted = false;
	
	private String name;
	private Boolean hasStates=true;
	
	public Country() {
		super();
	}
	
	public Country(Integer pk) {
		super();
		this.pk=pk;
	}
	
	@Override
	@Id
	@Column(name="countryID", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getPk() {
		return pk;
	}

	@Override
	public void setPk(Integer pk) {
		this.pk=pk;
	}

	@Override
	@Column(name="dateAdded", nullable=false)
	public Date getDateAdded() {
		return dateAdded;
	}

	@Override
	public void setDateAdded(Date dateAdded) {
		this.dateAdded=dateAdded;
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
		this.isDeleted=isDeleted;
	}

	@Column(name="name", nullable=false, unique=true, length=150)
	@NaturalId
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="hasStates", nullable=false)
	public Boolean getHasStates() {
		return hasStates;
	}

	public void setHasStates(Boolean hasStates) {
		this.hasStates = hasStates;
	}

}

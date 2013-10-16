package com.johnsully83.model.cloud.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;

import com.johnsully83.model.cloud.CloudTable;

@Entity(name="State")
@Embeddable
public class State implements CloudTable<Integer> {
	private static final long serialVersionUID = -3707213713939587606L;
	
	private Integer pk;
	private Date dateAdded = new Date();
	private Date dateLastModified = new Date();
	private Boolean isDeleted = false;
	
	private String name;
	private Country country;
	
	public State() {
		super();
	}
	
	public State(Integer pk) {
		super();
		this.pk=pk;
	}

	@Override
	@Id
	@Column(name="stateID", nullable=false)
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
		this.dateLastModified=dateLastModified;
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

	@Column(name="name", nullable=false, unique = true, length=150)
	@NaturalId
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Embedded
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="countryID", nullable=false)
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}

package com.johnsully83.model.cloud.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.johnsully83.model.cloud.CloudTable;

@Entity(name="Guest")
public class Guest implements CloudTable<Integer> {
	private static final long serialVersionUID = 8198404124008314412L;
	
	private Integer pk;
	private Date dateAdded = new Date();
	private Date dateLastModified = new Date();
	private Boolean isDeleted = false;
	
	private String name;
	private City city;
	private State state;
	private Country country;
	private String email;
	private Integer age;
	
	private String comments;
	
	public Guest() {
		super();
	}
	
	public Guest(Integer pk) {
		super();
		this.pk=pk;
	}

	@Override
	@Id
	@Column(name="guestID", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getPk() {
		return pk;
	}

	@Override
	public void setPk(Integer pk) {
		this.pk=pk;
	}
	
	@Override
	@Column(name="dateAdded", nullable=false, updatable=false)
	@NotNull
	public Date getDateAdded() {
		return dateAdded;
	}

	@Override
	public void setDateAdded(Date dateAdded) {
		this.dateAdded=dateAdded;
	}

	@Override
	@Column(name="dateLastModified", nullable=false)
	@NotNull
	public Date getDateLastModified() {
		return dateLastModified;
	}

	@Override
	public void setDateLastModified(Date dateLastModified) {
		this.dateLastModified=dateLastModified;
	}

	@Override
	@Column(name="isDeleted", nullable=false)
	@NotNull
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	@Override
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted=isDeleted;
	}
	
	@Column(name="name", nullable=false, length=150)
	@NotEmpty
	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Embedded
	@ManyToOne(fetch=FetchType.EAGER, optional=true)
	@JoinColumn(name="cityID", nullable=true)
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Embedded
	@ManyToOne(fetch=FetchType.EAGER, optional=true)
	@JoinColumn(name="stateID", nullable=true)
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Embedded
	@ManyToOne(fetch=FetchType.EAGER, optional=true)
	@JoinColumn(name="countryID", nullable=true)
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name="email", length=150)
	@Email
	@NotEmpty
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="age")
	@Range(min=0, max=150)
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name="comments", length=8000)
	@Size(max=8000)
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}

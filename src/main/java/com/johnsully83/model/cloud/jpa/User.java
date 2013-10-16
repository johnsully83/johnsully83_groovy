package com.johnsully83.model.cloud.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.johnsully83.model.cloud.CloudTable;
import com.johnsully83.model.enumeration.main.UserType;

@Entity(name="User")
public class User implements CloudTable<Integer> {
	private static final long serialVersionUID = -8279382900840060259L;

	private Integer pk;
	private Date dateAdded;
	private Date dateLastModified;
	private Boolean isDeleted;
	
	private String username;
	private String password;
	private String email;
	
	private UserType userType;
	
	public User(Integer pk) {
		super();
		this.pk=pk;
	}
	
	@Override
	@Id
	@Column(name="userID", nullable=false)
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

	@Column(name="username", nullable=false, length=25, unique=true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="password", nullable=false, length=25)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="email", nullable=false, length=50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="userType", nullable=false)
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}

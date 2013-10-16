package com.johnsully83.model.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class LoginForm {
	
	private String username;
	private String password;
	private String email;
	
	public LoginForm() {
		super();
	}
	
	public LoginForm(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	@Size(min=3, max=25)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Size(min=3, max=25)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Size(min=3, max=50)
	@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		LoginForm other = (LoginForm) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginForm [username=" + username + ", password=" + password
				+ ", email=" + email + "]";
	}

}

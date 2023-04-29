package com.capgemini.moviesystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@Column(name = "Username", length = 20)
	private String username;
	@Column(name = "Password", length = 10)
	private String password;
	@Column(name = "Name", length = 20)
	private String name;
	@Column(name = "Contact", length = 10)
	private String contact;

	public Customer() {
	}

	public Customer(String username, String password, String name, String contact) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.contact = contact;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", name=" + name + ", contact=" + contact
				+ "]";
	}
}

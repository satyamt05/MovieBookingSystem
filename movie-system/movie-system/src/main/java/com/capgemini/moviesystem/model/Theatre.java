package com.capgemini.moviesystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Theatre")
public class Theatre {

	@Id
	@SequenceGenerator(name = "seqn", initialValue = 2001)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqn")
	@Column(name = "theatre_id", length = 10)
	private int id;
	@Column(name = "theatre_name", length = 20)
	private String name;

	@Column(name = "theatre_city", length = 20)
	private String city;

	@Column(name = "manager_name", length = 20)
	private String managerName;

	@Column(name = "manager_contact", length = 20)
	private String managerContact;

	public Theatre() {

	}

	public Theatre(int id, String name, String city, String managerName, String managerContact) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}

	@Override
	public String toString() {
		return "Theatre [id=" + id + ", name=" + name + ", city=" + city + ", managerName=" + managerName
				+ ", managerContact=" + managerContact + "]";
	}

}

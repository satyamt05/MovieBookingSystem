package com.capgemini.moviebookingsystem.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Screen")
public class Screen {

	@Id
	@Column(name = "screen_id", length = 10)
	private int id;
	@Column(name = "screen_name", length = 20)
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theatre_id", referencedColumnName = "theatre_id")
	private Theatre theatreId;
	@Column(name = "movie_end_date", length = 20)
	private Date endDate;

	public Screen() {

	}

	public Screen(int id, String name, Theatre theatreId) {
		super();
		this.id = id;
		this.name = name;
		this.theatreId = theatreId;
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

	public Theatre getThreatreId() {
		return theatreId;
	}

	public void setThreatreId(Theatre theatreId) {
		this.theatreId = theatreId;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Screen [id=" + id + ", name=" + name + ", theatreId=" + theatreId + ",endDate=" + endDate + "]";
	}

}

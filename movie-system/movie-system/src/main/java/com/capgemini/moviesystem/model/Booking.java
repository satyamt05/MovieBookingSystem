package com.capgemini.moviesystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking {
	@Id
	@SequenceGenerator(name = "seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int bookingId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "showId", referencedColumnName = "showId")
	private Show showId;

	@Column(name = "booking_Date")
	private Date bookingDate;

	@Column(name = "totalCost")
	private int totalCost;

	@Column(name = "noOfSeats")
	private int noOfSeats;

	@Column(name = "username")
	private String username;

	public Booking() {
		super();
	}

	public Booking(int bookingId, Show showId, Date bookingDate, int noOfSeats, int totalCost, String username) {
		super();
		this.bookingId = bookingId;
		this.showId = showId;
		this.noOfSeats = noOfSeats;
		this.bookingDate = bookingDate;
		this.totalCost = totalCost;
		this.username = username;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Show getShowId() {
		return showId;
	}

	public void setShowId(Show showId) {
		this.showId = showId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", showId=" + showId + ", bookingDate=" + bookingDate
				+ ", totalCost=" + totalCost + ", noOfSeats=" + noOfSeats + ", username=" + username + "]";
	}

}

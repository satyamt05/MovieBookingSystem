package com.capgemini.moviesystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ticket")
public class Ticket {

	@Id
	@GeneratedValue
	@Column(name = "ticketId")
	private int ticketId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookingId", referencedColumnName = "bookingId")
	private Booking bookingId;

	public Ticket() {
		super();
	}

	public Ticket(int ticketId, Booking bookingId) {
		super();
		this.ticketId = ticketId;
		this.bookingId = bookingId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Booking getBookingId() {
		return bookingId;
	}

	public void setBookingId(Booking bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", bookingId=" + bookingId + "]";
	}

}

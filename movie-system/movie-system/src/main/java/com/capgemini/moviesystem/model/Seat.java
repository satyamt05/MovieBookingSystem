package com.capgemini.moviesystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Seat")
public class Seat {

	@Id
	@Column(name = "seatId", unique = true, length = 20)
	private int seatId;

	@Enumerated(EnumType.STRING)
	private SeatStatus seatStatus;

	@Column(name = "seatPrice", unique = true, length = 20)
	private double seatPrice;

	public Seat() {

	}

	public Seat(int seatId, SeatStatus seatStatus, double seatPrice) {
		super();
		this.seatId = seatId;
		this.seatStatus = seatStatus;
		this.seatPrice = seatPrice;
	}

	public Seat(Seat id, SeatStatus booked, int seatPrice) {
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public SeatStatus getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(SeatStatus seatStatus) {
		this.seatStatus = seatStatus;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}

	public SeatStatus blockSeat() {
		this.setSeatStatus(SeatStatus.AVAILABLE.BLOCKED);
		return this.seatStatus;
	}

	public Seat bookSeat() {
		this.setSeatStatus(SeatStatus.AVAILABLE.BOOKED);
		return this;
	}

	public Seat cancelSeatBooking() {
		this.setSeatStatus(SeatStatus.AVAILABLE.AVAILABLE);
		return this;
	}
}

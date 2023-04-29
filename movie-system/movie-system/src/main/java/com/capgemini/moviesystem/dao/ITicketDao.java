package com.capgemini.moviesystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.moviesystem.model.Ticket;

public interface ITicketDao extends JpaRepository<Ticket, Integer> {

	@Query("select t from Ticket t where t.bookingId.bookingId=:bookingId")
	public List<Ticket> getByBookingId(@Param("bookingId") int bookingId);

}

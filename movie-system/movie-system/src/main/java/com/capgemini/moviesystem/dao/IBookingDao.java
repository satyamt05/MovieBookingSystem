package com.capgemini.moviesystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.capgemini.moviesystem.model.Booking;

@Repository
public interface IBookingDao extends JpaRepository<Booking, Integer> {

	@Query("select b from Booking b where b.bookingId=:bookingId")
	public Booking getById(@Param("bookingId") int bookingId);
}

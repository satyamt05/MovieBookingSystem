package com.capgemini.moviesystem.service;

import java.sql.Date;
import java.util.List;

import com.capgemini.moviesystem.exception.ShowNotFoundException;
import com.capgemini.moviesystem.model.Booking;
import com.capgemini.moviesystem.model.Customer;
import com.capgemini.moviesystem.model.Movie;
import com.capgemini.moviesystem.model.Seat;
import com.capgemini.moviesystem.model.Show;
import com.capgemini.moviesystem.model.Theatre;

public interface CustomerService {

//-------------------------Customer Module-------------------------------------------------------------

	public Customer login(String username, String password);

	public Customer addCustomer(Customer cust);

	public Customer getCustomer(String username);

//-------------------------Movie Module------------------------------------------------------------------

	public Movie getMovieById(int id);

	public Movie getMovieByName(String name);

	public List<Movie> getAllMovies();

 //-------------------------Theatre Module------------------------------------------------------------

	public Theatre getTheatreById(int id);

	public Theatre getTheatreByName(String name);

	public List<Theatre> getAllTheatres();

 //-------------------------Seat Module------------------------------------------------------------

	Seat addSeat(Seat seat);

	Seat getSeat(int seatId);

	Seat blockSeat(int seatId);

	Seat bookSeat(int seatId);

	Seat cancelSeat(int seatId);

	List<Seat> getAllSeats();

	public boolean deleteSeat(int seatId);

	//----------------------------Show Module-----------------------------------------------------------

	Show findById(int showId) throws ShowNotFoundException;

	List<Show> fetchAllShows();

	public List<Show> getShowsByMovieId(int movieId);
	
	//----------------------------Booking Module---------------------------------------------------------

	public Booking addBooking(Booking booking);

	public Boolean deleteBooking(int id);

	public void calculateTotalCost(int showId, int noOfSeats, Date bookingDate, String username)
			throws ShowNotFoundException;

	public Booking getBookingById(int id);

	public List<Booking> getAllBookings();
	

}

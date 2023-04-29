package com.capgemini.moviesystem.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.moviesystem.dao.IBookingDao;
import com.capgemini.moviesystem.dao.ICustomerDao;
import com.capgemini.moviesystem.dao.IMovieDao;
import com.capgemini.moviesystem.dao.ISeatDao;
import com.capgemini.moviesystem.dao.IShowDao;
import com.capgemini.moviesystem.dao.ITheatreDao;
import com.capgemini.moviesystem.exception.BookingNotFoundException;
import com.capgemini.moviesystem.exception.CustomerNotFoundException;
import com.capgemini.moviesystem.exception.MovieListEmptyException;
import com.capgemini.moviesystem.exception.MovieNotFoundException;
import com.capgemini.moviesystem.exception.SeatNotFoundException;
import com.capgemini.moviesystem.exception.ShowNotFoundException;
import com.capgemini.moviesystem.exception.TheatreListEmptyException;
import com.capgemini.moviesystem.exception.TheatreNotFoundException;
import com.capgemini.moviesystem.model.Booking;
import com.capgemini.moviesystem.model.Customer;
import com.capgemini.moviesystem.model.Movie;
import com.capgemini.moviesystem.model.Seat;
import com.capgemini.moviesystem.model.SeatStatus;
import com.capgemini.moviesystem.model.Show;
import com.capgemini.moviesystem.model.Theatre;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired 
	ICustomerDao customerDao;
	
	@Autowired
	private IMovieDao movieDao;
	
	@Autowired
	private ITheatreDao theatreDao;
	
	@Autowired
	private ISeatDao seatDao;
	
	@Autowired
	private IShowDao showDao;
	
	@Autowired
	private IBookingDao bookingDao;
	
	//-----------------------------Customer Module--------------------------------------------
		
	/**
	 * method name: login
	 * method desc: to check the username and password of customer
	 * parameters:  String type - username, String type - password 
	 * return type: Customer 
	 * method type: retrieve 
	 * author name: Shivani
	 */
	@Override
	public Customer login(String username, String password) {
		Customer customer = customerDao.getCustomer(username);
		if ((customer.getUsername()).equals(username) && (customer.getPassword().equals(password))) {
			return customer;
		}
		throw new CustomerNotFoundException(
				"Customer with username - " + username + " and password " + password + " does not exists.");
	}
	
	/**
	 * method name: addCustomer
	 * method desc: to add the customer details in the database
	 * parameters:  Customer type - cust
	 * return type: Customer 
	 * method type: add 
	 * author name: Shivani
	 */
	@Override
	public Customer addCustomer(Customer cust) {
		return customerDao.addCustomer(cust);
	}
	
	/**
	 * method name: getCustomer
	 * method desc: to get the customer details from the database
	 * parameters:  String type - username
	 * return type: Customer 
	 * method type: fetch
	 * author name: Shivani
	 */
	@Override
	public Customer getCustomer(String username) {
		return customerDao.getCustomer(username);
	}
	
	//----------------------------Movie Module---------------------------------------------------
	
	
	/**
	 * method name: getMovieById
	 * method desc: gets a id of movie and fetch from database through get by id method 
	 * parameters:  int type - id 
	 * return type: Movie 
	 * method type: retrieve 
	 * author name: Shivani
	 */
	@Override
	public Movie getMovieById(int id) {
		Movie movie = movieDao.getById(id);
		logger.trace("Customer Service - Get movie by id method ");
		if (movie != null) {
			logger.info("Movie Found");
			return movie;
		}
		logger.error("Error occurred.");
		throw new MovieNotFoundException("Movie with id " + id + " do not exists");
	}

	/**
	 * method name: getMovieByName
	 * method desc: get a name of movie and fetch from database through get by name method 
	 * parameters:  String type - name
	 * return type: Movie 
	 * method type: retrieve 
	 * author name: Shivani
	 */
	@Override
	public Movie getMovieByName(String name) {
		logger.trace("Customer Service - Get movie by name method ");
		Movie movie = movieDao.getByName(name);
		if (movie != null) {
			logger.info("Movie Found");
			return movie;
		}
		logger.error("Error occurred");
		throw new MovieNotFoundException("Movie with name " + name + " does not exists..");
	}

	/**
	 * method name: getAllMovies 
	 * method desc: fetch the list of all the movies present in the database 
	 * parameters:  no parameters 
	 * return type: List of Movie type 
	 * method type: retrieve 
	 * author name: Shivani
	 */
	@Override
	public List<Movie> getAllMovies() {
		logger.trace("Customer Service - Get all movies method ");
		List<Movie> movies = new ArrayList<>();
		movieDao.findAll().forEach(m -> movies.add(m));
		if (!movies.isEmpty()) {
			return movies;
		}
		logger.error("Error occurred");
		throw new MovieListEmptyException("Movie list is empty");
	}
	
	
	//------------------------Theatre Module----------------------------------------------
	
	/**
	 * method name: getTheatreById 
	 * method desc: gets a id of theatre and fetch the theatre with given id from database
	 * parameters : int type - id 
	 * return type: Theatre 
	 * method type: retrieve 
	 * author name: Shubhi
	 */	

	@Override
	public Theatre getTheatreById(int id) {
		logger.trace("Customer service layer--Get theatre by id method");
		Theatre theatre = theatreDao.getTheatreById(id);
		if (theatre != null) {
			logger.info("Theatre with given id is fetched");
			return theatre;
		}
		logger.error("Error has ocurred");
		throw new TheatreNotFoundException("Theatre with id " + id + " does not exists");

	}
	
	/**
	 * method name: getTheatreByName 
	 * method desc: gets a name of theatre and fetch the theatre with given name from database
	 * parameters : String type - name
	 * return type: Theatre 
	 * method type: retrieve 
	 * author name: Shubhi
	 */	

	@Override
	public Theatre getTheatreByName(String name) {
		logger.trace("Customer service layer--Get theatre by name method");
		Theatre theatre = theatreDao.getTheatreByName(name);
		if (theatre != null) {
			logger.info("Theatre with given name is fetched");
			return theatre;
		}
		logger.error("Error has ocurred");
		throw new TheatreNotFoundException("Theatre with name " + name + " does not exists");

	}

	/**
	 * method name: getAllTheatres
	 * method desc: fetch the list of all the theatres present in the database 
	 * parameters : no parameters 
	 * return type: List of Theatre type 
	 * method type: retrieve 
	 * author name: Shubhi
	 */ 
	
	@Override
	public List<Theatre> getAllTheatres() {
		logger.trace("Customer service layer--View all theatres method");
		List<Theatre> theatres = new ArrayList<>();
		theatreDao.findAll().forEach(t -> theatres.add(t));
		if (!theatres.isEmpty()) {
			logger.info("Success");
			return theatres;
		}
		logger.error("Error has ocurred.");
		throw new TheatreListEmptyException("Theatre list is empty!!");

	}
	
	//--------------------------Seat Module---------------------------------------------------------
	
	/**
	 * Method Name___________________________:addSeat
	 * Method Description____________________:to add seat details in database system.
	 * Method Input Parameter________________:seat
	 * Method Return Type____________________:Seat
	 * Method Type___________________________:Post
	 * Author Name___________________________:Alok Singh Gaur
	 * Method Last Modified__________________:25/11/20
	 */
	
	@Override
	public Seat addSeat(Seat seat) {
		logger.trace("Add Seat method");
		seatDao.save(seat);
		return seat;
	}
	
	/**
	 * Method Name___________________________:getSeat
	 * Method Description____________________:to get the seat details based on its corresponding seat Id.
	 * Method Input Parameter________________:seatId
	 * Method Return Type____________________:Seat
	 * Method Type___________________________:Get
	 * Author Name___________________________:Alok Singh Gaur
	 * Method Last Modified__________________:25/11/20
	 */
	
	@Override
	public Seat getSeat(int seatId){
		logger.trace("Get Seat by id method");
        Optional<Seat> optional = seatDao.findById(seatId);
        if(optional.isPresent())
        {
            return optional.get();
        }
        	throw new SeatNotFoundException("Seat not found for id:"+seatId);
    }
	
	
	/**
	 * Method Name___________________________:blockSeat
	 * Method Description____________________:to block the seat  based on its corresponding seat Id.
	 * Method Input Parameter________________:seatId
	 * Method Return Type____________________:Seat
	 * Method Type___________________________:Put
	 * Author Name___________________________:Alok Singh Gaur
	 * Method Last Modified__________________:25/11/20
	 */
	
	
	@Override
	public Seat blockSeat(int seatId){
		logger.trace("Block seat method ");
      Seat seat = getSeat(seatId);
      seat.setSeatStatus(SeatStatus.BLOCKED);
      seatDao.save(seat);
      return seat;
  }
	
	
	/**
	 * Method Name___________________________:bookSeat
	 * Method Description____________________:to book the seat  based on its corresponding seat Id.
	 * Method Input Parameter________________:seatId
	 * Method Return Type____________________:Seat
	 * Method Type___________________________:Put
	 * Author Name___________________________:Alok Singh Gaur
	 * Method Last Modified__________________:25/11/20
	 */
	
	
	@Override
	public Seat bookSeat(int seatId){
		logger.trace("Book Seat Method");
      Seat seat = getSeat(seatId);
      seat.setSeatStatus(SeatStatus.BOOKED);
      seatDao.save(seat);
      return seat;
  }
	
	/**
	 * Method Name___________________________:Seat
	 * Method Description____________________:to cancel the seat  based on its corresponding seat Id.
	 * Method Input Parameter________________:seatId
	 * Method Return Type____________________:Seat
	 * Method Type___________________________:Put
	 * Author Name___________________________:Alok Singh Gaur
	 * Method Last Modified__________________:25/11/20
	 */
	
	
	@Override
	public Seat cancelSeat(int seatId){
		logger.trace("Cancel Seat Method");
      Seat seat = getSeat(seatId);
      seat.setSeatStatus(SeatStatus.AVAILABLE);
      seatDao.save(seat);
      return seat;
  }
	
	
	/**
	 * Method Name___________________________:getAllSeats
	 * Method Description____________________:to get all the seat details that are available in database.
	 * Method Input Parameter________________:
	 * Method Return Type____________________:List<Seat>
	 * Method Type___________________________:Get
	 * Author Name___________________________:Alok Singh Gaur
	 * Method Last Modified__________________:25/11/20
	 */
	
	@Override
	public List<Seat> getAllSeats() {
		logger.trace("Get all Seats method");
		 return seatDao.findAll();
	}	
	
	/**
	 * Method Name___________________________:deleteSeat
	 * Method Description____________________:to remove the seat details from the system.
	 * Method Input Parameter________________:seatId
	 * Method Return Type____________________:boolean
	 * Method Type___________________________:Delete
	 * Author Name___________________________:Alok Singh Gaur
	 * Method Last Modified__________________:25/11/20
	 */
	
	
	public boolean deleteSeat(int seatId) {
		if(!seatDao.existsById(seatId)) {
			throw new SeatNotFoundException("Seat with Id :" + seatId+" is Not Found");
		}
		else {
		seatDao.deleteById(seatId);		
		return !seatDao.existsById(seatId);
		}

	}

	//-------------------------Show Module--------------------------------------------------------
	
	
	/*
	 * findById method will fetch the data of particular show from Show table
	 * through "showId".
	 */
 public Show findById(int showId) throws ShowNotFoundException {
		logger.trace("Find show by id  method");
		Optional<Show> optional = showDao.findById(showId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new ShowNotFoundException("Show not found for id:" + showId);
		}
	}

	/*
	 * fetchAllShows method will fetch all the shows stored in Show table.
	 */
	public List<Show> fetchAllShows() {
		logger.trace("Find all show  method");
		return showDao.findAll();
	}
	
	
	@Override
	public List<Show> getShowsByMovieId(int movieId) {
	List<Show> shows=new ArrayList<>();
	showDao.getShowsByMovieId(movieId).forEach(s->shows.add(s));
	return shows;
	}
	
	
	//------------------------------Booking Module-------------------------------------------------------

	
	/**
	 * method name: calculateTotalCost
	 * method desc: to calculate the total cost for booking
	 * parameters:  int and string type
	 * return type: void
	 * method type: calculate
	 * author name: Shivani
	 */
	@Override
	public void calculateTotalCost(int showId, int noOfSeats, Date bookingDate, String username)
			throws ShowNotFoundException {
		Show show = findById(showId);
		int price = 200;
		int totalCost = 0;
		totalCost = noOfSeats * price;
		Booking booking = new Booking();
		booking.setShowId(show);
		booking.setNoOfSeats(noOfSeats);
		booking.setBookingDate(bookingDate);
		booking.setTotalCost(totalCost);
		booking.setUsername(username);
		addBooking(booking);
	}
	/**
	 * method name: addBooking
	 * method desc: to add the booking class object by calling save method
	 * parameters:  Booking type-booking
	 * return type: Booking
	 * method type: add
	 * author name: Shivani
	 */
	
	public Booking addBooking(Booking booking) {
		int price = 200;
		int totalCost = 0;
		totalCost = (booking.getNoOfSeats()) * price;
		booking.setTotalCost(totalCost);

		booking = bookingDao.save(booking);
		int noOfSeats = booking.getNoOfSeats();
		for (int i = 10; i <= noOfSeats; i++) {
			Seat seat = new Seat();
			seat.setSeatId(i);
			seat.setSeatStatus(SeatStatus.BOOKED);
			if (seatDao.save(seat) != null) {
				logger.info("seat generated with id:");
			}
		}
		return booking;
	}
		
	/**
   	 * method name: deleteBooking
   	 * method desc: to delete booking details through booking id
   	 * parameters: int type - id
   	 * return type: boolean
   	 * method type: delete
   	 * author name: Shivani
   	 */
	
	@Override
	public Boolean deleteBooking(int id) {
		logger.trace("Admin service layer--Delete theatre by id method");
		Booking booking = bookingDao.getById(id);
		if (booking != null) {
			bookingDao.deleteById(id);
			logger.info("Booking cancelled");
			return true;
		} else {
			logger.error("Exception occured");
			throw new BookingNotFoundException("Booking with this id " + id + " do not exists");
		}

	}
	
	/**
	 * method name: getBookingById
	 * method desc: to fetch details of booking through booking id
	 * parameters:  int type - id
	 * return type: Booking
	 * method type: retrieve
	 * author name: Shivani
	 */	
	@Override
	public Booking getBookingById(int id) {
		Booking booking = bookingDao.getById(id);
		if (booking != null) {
			return booking;
		}
		throw new BookingNotFoundException("Trainee is not present with given Id: " + id);

	}

/**
	 * method name: getAllBookings
	 * method desc: to fetch all booking details
	 * parameters:  none
	 * return type: List of Booking type
	 * method type: retrieve
	 * author name: Shivani
	 */
public List<Booking> getAllBookings() {
	List<Booking> bookings = new ArrayList<>();
	bookingDao.findAll().forEach(m -> bookings.add(m));
	return bookings;

}

}



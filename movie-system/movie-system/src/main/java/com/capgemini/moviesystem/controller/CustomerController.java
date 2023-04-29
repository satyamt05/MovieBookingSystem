package com.capgemini.moviesystem.controller;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviesystem.exception.SeatNotFoundException;
import com.capgemini.moviesystem.exception.ShowNotFoundException;
import com.capgemini.moviesystem.model.Booking;
import com.capgemini.moviesystem.model.Customer;
import com.capgemini.moviesystem.model.Movie;
import com.capgemini.moviesystem.model.Seat;
import com.capgemini.moviesystem.model.Show;
import com.capgemini.moviesystem.model.Theatre;
import com.capgemini.moviesystem.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	
	//----------------------Customer Module-------------------------------------------------
	
	/**
	*method name: loginCustomer
	*method desc: to get the details of customer to login
	*parameters: String type - username, String type - password
	*return type: Customer
	*method type: get
	*authorName: Shivani
	*/
	@GetMapping(value = "/login/username/{username}/password/{password}")
	public Customer loginCustomer(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		return customerService.login(username, password);
	}
		
	/**
	*method name: addCustomer
	*method desc: to add the customer with the customer details
	*parameters: Customer type - cust
	*return type: Customer
	*method type: post
	*authorName: Shivani
	*/
	
	@PostMapping(value = "/customers")
	public Customer addCustomer(@RequestBody Customer cust) {
		return customerService.addCustomer(cust);

	}
		
		/**
		*method name: getCustomer
		*method desc: to fetch the details of customer through the username
		*parameters: String type - username
		*return type: Customer
		*method type: get
		*authorName: Shivani
		*/
		
		@GetMapping(value = "/customers/{username}")
		public Customer getCustomer(@PathVariable("username") String username) {
			return customerService.getCustomer(username);

		}
		
	
 //---------------------Movie module---------------------------------------------------------------------

	/**
	 * method name: getMovieById
	 * method desc: to fetch the details of movie through movie id by calling the method of service class.
	 * parameters:  int type - movieId
	 * return type: Movie
	 * method type: get
	 * author name: Shivani
	 */
	@GetMapping(value = "/movies/{movieId}")
	public Movie getMovieById(@PathVariable("movieId") int movieId) {
		logger.trace("Customer Controller - Get movie by id method");
		return customerService.getMovieById(movieId);
	}

	/**
	 * method name: getMovieByName
	 * method desc: to fetch the details of movie through movie name by calling the method of service class.
	 * parameters:  String type - movieName
	 * return type: Movie
	 * method type: get
	 * author name: Shivani
	 */
	@GetMapping(value = "/moviesn/{movieName}")
	public Movie getMovieByName(@PathVariable("movieName") String movieName) {
		logger.trace("Customer Controller - Get movie by name method");
		return customerService.getMovieByName(movieName);
	}

	/**
	 * method name: listOfMovies
	 * method desc: calls the method of service class and fetch all the movies.
	 * parameters:  no parameters
	 * return type: List of Movie Type
	 * method type: get
	 * author name: Shivani
	 */
	@GetMapping(value = "/movies")
	public List<Movie> listOfMovies() {
		logger.trace("Customer Controller - View all Movies method");
		logger.info("Showing all movies");
		return customerService.getAllMovies();
	}
	
	
	//----------------------------Theatre Module------------------------------------------------------------
	
	
	/**
	 * method name: getTheatreById
	 * method desc: to fetch the details of theatre through theatre id by calling the method of service class.
	 * parameters : int type - theatreId
	 * return type: Theatre
	 * method type: get
	 * author name: Shubhi
	 */

	@GetMapping("/theatres/{theatreId}")
	public Theatre getTheatreById(@PathVariable("theatreId") int theatreId) {
		logger.trace("Customer Controller--Get theatre by Id method");
		return customerService.getTheatreById(theatreId);

	}
	
	/**
	 * method name: getTheatreByName
	 * method desc: to fetch the details of theatre through theatre name by calling the method of service class.
	 * parameters : String type - theatreName
	 * return type: Theatre
	 * method type: get
	 * author name: Shubhi
	 */

	@GetMapping("/theatresn/{theatreName}")
	public Theatre getTheatreByName(@PathVariable("theatreName") String theatreName) {
		logger.trace("Customer Controller--Get theatre by Name method");
		return customerService.getTheatreByName(theatreName);

	}
	
	/**
	 * method name: listOfTheatres
	 * method desc: calls the method of service class and fetch all the theatres.
	 * parameters : no parameters
	 * return type: List of Theatre Type
	 * method type: get
	 * author name: Shubhi
	 */

	@GetMapping("/theatres")
	public List<Theatre> listOfTheatres() {
		logger.trace("Customer Controller--View all theatre method");
		logger.info("Success");
		return customerService.getAllTheatres();
	}
	
	//---------------Seat Module---------------------------------------------------------------
	
	
	/**
	 * Method Name___________________________:addSeat
	 * Method Description____________________:to add seat details in database system.
	 * Method Input Parameter________________:seat
	 * Method Return Type____________________:Seat
	 * Method Type___________________________:Post
	 * Author Name___________________________:Alok Singh Gaur
	 * Method Last Modified__________________:25/11/20
	 */
	
	@PostMapping("/addSeat")
	public ResponseEntity<Seat> addSeat(@RequestBody Seat requestData) {
		logger.trace("Add Seat method");
	    Seat seat = convertToSeat(requestData);
	    Seat seat1=customerService.addSeat(seat);
	    return new ResponseEntity<>(seat1, HttpStatus.OK);
	}
	
	public Seat convertToSeat(Seat requestData)  {
	    Seat seat = new Seat();
	    seat.setSeatId(requestData.getSeatId());
	    seat.setSeatStatus(requestData.getSeatStatus());
	    seat.setSeatPrice(requestData.getSeatPrice());
	    
	    return seat;
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
	
	
	@PutMapping("/blockSeat/{id}")
    public ResponseEntity<Seat> blockSeat(@PathVariable("id") int seatId){
		logger.trace("Block seat method ");
        Seat seat = customerService.blockSeat(seatId);
        return new ResponseEntity<>(seat, HttpStatus.OK);
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
	
	
	@PutMapping("/bookSeat/{id}")
    public ResponseEntity<Seat> bookSeat(@PathVariable("id") int seatId){
		logger.trace("Book Seat Method");
        Seat seat = customerService.bookSeat(seatId);
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }
	
	
	/**
	 * Method Name___________________________:cancelSeat
	 * Method Description____________________:to cancel the seat  based on its corresponding seat Id.
	 * Method Input Parameter________________:seatId
	 * Method Return Type____________________:Seat
	 * Method Type___________________________:Put
	 * Author Name___________________________:Alok Singh Gaur
	 * Method Last Modified__________________:25/11/20
	 */
	
	@PutMapping("/cancelSeat/{id}")
    public ResponseEntity<Seat> cancelSeat(@PathVariable("id") int seatId){
		logger.trace("Cancel Seat Method");
        Seat seat = customerService.cancelSeat(seatId);
       return new ResponseEntity<>(seat, HttpStatus.OK);
    }
	

	/**
	 * Method Name___________________________:findSeatById
	 * Method Description____________________:to get the seat details based on its corresponding seat Id.
	 * Method Input Parameter________________:seatId
	 * Method Return Type____________________:Seat
	 * Method Type___________________________:Get
	 * Author Name___________________________:Alok Singh Gaur
	 * Method Last Modified__________________:25/11/20
	 */
	
	@GetMapping("/find/{id}")
    public ResponseEntity<Seat> findSeatById(@PathVariable("id")  int seatId){
		logger.trace("Get Seat by id method");
        Seat seat = customerService.getSeat(seatId);
        return new ResponseEntity<>(seat, HttpStatus.OK);

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
	
	@GetMapping("/getAllSeats")
	public ResponseEntity<List<Seat>> getAllSeats(){
		logger.trace("Get all Seats method");
		List<Seat> seatList = customerService.getAllSeats();
		return new ResponseEntity<>(seatList,HttpStatus.OK);
	}
	
	/*
	 * seatNotFound method to handle the exception
	 */

    @ExceptionHandler(SeatNotFoundException.class)
    public ResponseEntity<String> seatNotFound(SeatNotFoundException ex) {
        logger.info("SeatNotFound()");
        String msg = ex.getMessage();
        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
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
    
    @DeleteMapping( "/removeSeat/{seatId}")
	public boolean deleteSeat(@PathVariable int seatId) 
	{
		
		return customerService.deleteSeat(seatId);
	}
    
    
    
    //-----------------------Show Module----------------------------------------------------------------
    
    /**
	 * Method 	     : findShows()
	 * Description   : This is a GetMethod() that is used to get all the shows stored in Show table..
	 * Creation Type : List<Show>
	 * parameters    : null.
	 * Date 	     : 24-NOV-2020
	 **/
	
	@GetMapping("/getShows")
	public ResponseEntity<List<Show>> findShows() {
		logger.trace("Find all show  method");
		List<Show> showList = customerService.fetchAllShows();
		return new ResponseEntity<>(showList, HttpStatus.OK);
	}

	/*
	 * findShowById method will fetch the show data through "showId".
	 */
	
	/**
	 * Method 	     : findShowById(int showId)
	 * Description   : This is a GetMethod() that is used to get the show stored on a particular id in Show table..
	 * Creation Type : ResponseEntity<Show>
	 * parameters    : int showId.
	 * Date 	     : 24-NOV-2020
	 **/
	
	@GetMapping("/getShowById/{id}")
	public ResponseEntity<Show> findShowById(@PathVariable("id") int showId) throws ShowNotFoundException {
		logger.trace("Find show by id  method");
		Show show = customerService.findById(showId);
		return new ResponseEntity<>(show, HttpStatus.OK);
	}

	/*
	 * showNotFound method tof handle the exception.
	 */
	@ExceptionHandler(ShowNotFoundException.class)
	public ResponseEntity<String> showNotFound(ShowNotFoundException ex) {
		logger.error("showNotFound()", ex);
		String msg = ex.getMessage();
		return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
	}

	@GetMapping(value="/select/{id}")
	public List<Show> getShowsByMovieId(@PathVariable("id") int movieId){
	logger.trace("Get all show by movie id method");
	return customerService.getShowsByMovieId(movieId);
	}
	
	
	//-------------------------Booking Module -------------------------------------------------------------
	

	/**
	 * method name: calculateTotalCost
	 * method desc: to add object of booking class by passing booking object by calling method of service class
	 * parameters:  int and String type 
	 * return type: void
	 * method type: post
	 * author name: Shivani
	 */	
	
	@PostMapping(value = "/add")
	public void calculateTotalCost(@RequestParam("showId") int showId, @RequestParam("noOfSeats") int noOfSeats,
			@RequestParam("bookingDate") Date bookingDate, @RequestParam("username") String username)
			throws ShowNotFoundException {

		customerService.calculateTotalCost(showId, noOfSeats, bookingDate, username);
	}
	
	/**
	 * method name: addBooking
	 * method desc: to add object of booking class by passing booking object by calling method of service class
	 * parameters:  Booking type - booking
	 * return type: Booking
	 * method type: post
	 * author name: Shivani
	 */	
	
	@PostMapping(value = "/addBooking")
	public Booking addBooking(@RequestBody Booking booking) {
		return customerService.addBooking(booking);

	}
	
	/**
	 * method name: getBooking
	 * method desc: to view booking details by passing id through url by calling method of service class
	 * parameters:  int type - id
	 * return type: Booking
	 * method type: get
	 * author name: Shivani
	 */	
	
	@GetMapping(value="/viewBooking/{id}")
	public Booking getBooking(@PathVariable("id") int id){
		Booking booking=null;
	    booking=customerService.getBookingById(id);
		return booking;
	}
	
	/**
	 * method name: deleteBooking
	 * method desc: to delete booking by passing id through url by calling method of service class
	 * parameters:  int type - id
	 * return type: boolean
	 * method type: delete
	 * author name: Shivani
	 */	
	
	@DeleteMapping(value="/deleteBooking/{id}")
	public Boolean deleteBooking(@PathVariable("id") int id) {
		return customerService.deleteBooking(id);
	}
	
	/**
	 * method name: getAllBookings
	 * method desc: to fetch details of all bookings through uri by calling method of service class
	 * parameters:  no parameter
	 * return type: List of Booking type
	 * method type: get
	 * author name: Riya
	 */	

	@GetMapping(value="/viewAll")
	public List<Booking> getAllBookings() {
		return customerService.getAllBookings();
	}
	
	
}
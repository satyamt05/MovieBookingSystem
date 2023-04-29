package com.capgemini.moviesystem.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviesystem.exception.AdminNotFoundException;
import com.capgemini.moviesystem.exception.ScreenNotFoundException;
import com.capgemini.moviesystem.model.Movie;
import com.capgemini.moviesystem.model.Screen;
import com.capgemini.moviesystem.model.Show;
import com.capgemini.moviesystem.model.Theatre;
import com.capgemini.moviesystem.service.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;
	
	// ---------------------------Admin Module-------------------------------------------------------
		
	/**
	*method name: getAdmin
	*method desc: to get the details of admin
	*parameters: String type - username, String type - password
	*return type: boolean
	*method type: get
	*authorName: Shivani
	*/
	@GetMapping("/login/{username}/{password}")
	public boolean getAdmin(@PathVariable("username") String username, @PathVariable("password") String password)
		throws AdminNotFoundException {
		
		logger.trace("Get admin method");
		return adminService.getAdmin(username, password);

	}

	// -----------------------Movie Module---------------------------------------------------------------------
	
	/**
	 * method name: addMovie
	 * method desc: add a movie class object by calling the method of service class.
	 * parameters:  Movie type - movie
	 * return type: Movie
	 * method type: post
	 * author name: Shivani
	 */
	@PostMapping(value = "/movies")
	public Movie addMovie(@RequestBody Movie movie) {
		logger.trace("Admin Controller - Add Movie method");
		logger.info("Adding new movie");
		return adminService.addMovie(movie);
	}

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
		logger.trace("Admin Controller - Get movie by id method");
		return adminService.getMovieById(movieId);
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
		logger.trace("Admin Controller - Get movie by name method");
		return adminService.getMovieByName(movieName);
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
		logger.trace("Admin Controller - View all Movies method");
		logger.info("Showing all movies");
		return adminService.getAllMovies();
	}

	/**
	 * method name: deleteMovie
	 * method desc: to delete the movie through movie id by calling the method of service class.
	 * parameters:  int type - movieId
	 * return type: boolean
	 * method type: delete
	 * author name: Shivani
	 */
	@DeleteMapping(value = "/movies/{movieId}")
	public boolean deleteMovie(@PathVariable("movieId") int movieId) {
		logger.trace("Admin Controller - Delete Movie by id method");
		adminService.deleteMovie(movieId);
		return true;
	}
	
	/**
	 * method name: updateMovie
	 * method desc: to update the movie object by calling the method of service class.
	 * parameters:  Movie type- movie, int type - movieId
	 * return type: Movie
	 * method type: put
	 * author name: Shivani
	 */
	@PutMapping(value = "/movies/{movieId}")
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable int movieId) {
		logger.trace("Admin Controller - Updated Movie by id method");
		return adminService.updateMovie(movie, movieId);
	}
	
 //---------------------------------Theatre Module----------------------------------------------------------
	
	
	
	/**
	 * method name: addTheatre
	 * method desc: add a theatre class object by calling the method of service class.
	 * parameters : Theatre type - theatre
	 * return type: Theatre
	 * method type: post
	 * author name: Shubhi
	 */

	@PostMapping(value = "/theatres")
	public Theatre addTheatre(@RequestBody Theatre theatre) {
		logger.trace("Admin Controller--Add theatre method");
		logger.info("Adding new theatre");
		return adminService.addTheatre(theatre);
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
		logger.trace("Admin Controller--View all theatre method");
		logger.info("Success");
		return adminService.getAllTheatres();
	}
	
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
		logger.trace("Admin Controller--Get theatre by Id method");
		return adminService.getTheatreById(theatreId);

	}
	
	/**
	 * method name: deleteTheatre
	 * method desc: to delete the theatre through theatre id by calling the method of service class.
	 * parameters : int type - theatreId
	 * return type: boolean
	 * method type: delete
	 * author name: Shubhi
	 */

	@DeleteMapping(value = "/theatres/{theatreId}")
	public Boolean deleteTheatre(@PathVariable("theatreId") int theatreId) {
		logger.trace("Admin Controller--Delete theatre by Id method");
		adminService.deleteTheatre(theatreId);
		return true;
	}
	
	/**
	 * method name: updateTheatre
	 * method desc: to update the theatre object by calling the method of service class.
	 * parameters : Theatre type- theatre, int type- theatreId
	 * return type: Theatre
	 * method type: put
	 * author name: Shubhi
	 */

	@PutMapping(value = "/theatres/{theatreId}")
	public Theatre updateTheatre(@RequestBody Theatre theatre, @PathVariable int theatreId) {
		logger.trace("Admin Controller--Update theatre by Id method");
		return adminService.updateTheatre(theatre, theatreId);

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
		logger.trace("Admin Controller--Get theatre by Name method");
		return adminService.getTheatreByName(theatreName);

	}
	
	
	//--------------------------Screen Module-------------------------------------------------------------

		/**
		 * method name: addScreen 
		 * method desc: add a screen class object by calling the method of service class. parameters: Screen type-screen returns: Screen
		 * method type: post 
		 * author name: Yashi
		 */
		@PostMapping(value = "/add")
		public Screen addScreen(@RequestBody Screen screen) {
			logger.trace("Add Screen method");
			return adminService.addScreen(screen);
		}

		/**
		 * method name: listOfScreen 
		 * method desc: to fetch details of all screens through uri by calling method of service class. parameters: no parameters
		 * returns: list of screen type
		 * method type: get 
		 * author name: Yashi
		 */
		@GetMapping(value = "/screens")
		public List<Screen> listOfScreen() {
			logger.trace("Get all Screen method");
			return adminService.getAllScreen();
		}

		/**
		 * method name: getAllScreen 
		 * method desc: to delete screen by passing screen id through uri by calling the method of service class. 
		 * parameters: int type-id
		 * returns: String 
		 * method type: delete
		 * author name: Yashi
		 */
		@DeleteMapping(value = "/screens/{id}")
		public String deleteScreen(@PathVariable("id") int id) {
			logger.trace("Delete Screen by id method");
			adminService.deleteScreen(id);
			return "deleted successfully";
		}

		/**
		 * method name: getScreen
		 * method desc: to fetch the details of screen by passing screen id through uri by calling method of service class. 
		 * parameters: int type-id 
		 * returns: Screen 
		 * method type: get 
		 * author name: Yashi
		 */
		@GetMapping(value = "/screens/{id}")
		public Screen getScreen(@PathVariable("id") int id) {
			logger.trace("Get Screen by id method");
			return adminService.getScreen(id);
		}

		/**
		 * method name: updateScreen
		 * method desc: update the object of screen by passing object by calling the method of service class. 
		 * parameters: Screen class type-screen 
		 * returns: Screen
		 *  method type: put
		 *  author name: Yashi
		 */
		@PutMapping(value = "/screens")
		public Screen updateScreen(@RequestBody Screen screen) {
			logger.trace("Update Screen method");
			return adminService.updateScreen(screen);
		}

		@GetMapping(value = "/screen/{name}")
		public Screen getScreen(@PathVariable("name") String name) {
			logger.trace("Get Screen by method method");
			return adminService.getScreen(name);
		}

		@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Screen with valid id or name not found")
		@ExceptionHandler(ScreenNotFoundException.class)
		public void handleScreenNotFoundException() {
			//Screen not found Exception

		}


	//-----------------------Show Module--------------------------------------------------
		
		/**
		 * Method 	     : addShow(Show requestData)
		 * Description   : This is a PostMethod() that is used to add the show to the Show table..
		 * Creation Type : ResponseEntity<Show>
		 * parameters    : Show requestData.
		 * Date 	     : 24-NOV-2020
		 **/

		@PostMapping("/addShow")

		public ResponseEntity<Show> addShow(@RequestBody Show requestData) {
			logger.trace("Add method");
			Show show = convertToShow(requestData);
			Show show1 = adminService.addShow(show);
			return new ResponseEntity<>(show1, HttpStatus.OK);
		}

		public Show convertToShow(Show requestData) {
			Show show = new Show();
			show.setShowId(requestData.getShowId());
			show.setShowStartTime(requestData.getShowStartTime());
			show.setShowEndTime(requestData.getShowEndTime());
			show.setAvailableSeats(requestData.getAvailableSeats());
			show.setShowName(requestData.getShowName());
			show.setMovieId(requestData.getMovieId());
			show.setScreenId(requestData.getScreenId());
			return show;
		}
		
		/**
		 * Method 	     : deleteShowById(int showId)
		 * Description   : This is a DeleteMethod() that is used to delete the show stored on the particular id in Show table..
		 * Creation Type : boolean
		 * parameters    : int showId.
		 * Date 	     : 24-NOV-2020
		 **/
		
		@DeleteMapping("/deleteShowById/{id}")
		public boolean deleteShowById(@PathVariable("id") int showId) {
			logger.trace("Delete method");
			return adminService.deleteShowById(showId);
		}
		
		/**
		 * Method 	     : updateShow(Show show)
		 * Description   : This is a PutMethod() that is used to update the show stored on the particular id in Show table..
		 * Creation Type : Show
		 * parameters    : Show show.
		 * Date 	     : 24-NOV-2020
		 **/
		
		@PutMapping(value = "/show/{id}")
		public Show updateShow(@RequestBody Show show) {
			logger.trace("Update method");
			return adminService.updateShowById(show);
		}

	}



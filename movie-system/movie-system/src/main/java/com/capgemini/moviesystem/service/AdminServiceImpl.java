package com.capgemini.moviesystem.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.moviesystem.dao.IScreenDao;
import com.capgemini.moviesystem.dao.IShowDao;
import com.capgemini.moviesystem.dao.IMovieDao;
import com.capgemini.moviesystem.dao.ITheatreDao;
import com.capgemini.moviesystem.exception.AdminNotFoundException;
import com.capgemini.moviesystem.exception.MovieListEmptyException;
import com.capgemini.moviesystem.exception.MovieNotFoundException;
import com.capgemini.moviesystem.exception.ScreenNotFoundException;
import com.capgemini.moviesystem.exception.TheatreListEmptyException;
import com.capgemini.moviesystem.exception.TheatreNotFoundException;
import com.capgemini.moviesystem.model.Movie;
import com.capgemini.moviesystem.model.Screen;
import com.capgemini.moviesystem.model.Show;
import com.capgemini.moviesystem.model.Theatre;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {

	Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private IMovieDao movieDao;

	@Autowired
	private ITheatreDao theatreDao;
	
	@Autowired
	private IScreenDao screenDao;
	
	@Autowired
	private IShowDao showDao;
	

	//-----------------------------Admin Module------------------------------------------------------
		
	/**
	 * method name: getAdmin
	 * method desc: to check the username and password of admin
	 * parameters:  String type - username, String type - password 
	 * return type: boolean 
	 * method type: retrieve 
	 * author name: Shivani
	 */
	@Override
	public boolean getAdmin(String username, String password) throws AdminNotFoundException {

		if ((username.equalsIgnoreCase("shivani")) && (password.equals("shivani26"))) {
			return true;
		}
		throw new AdminNotFoundException("Admin: " + username + " or " + password + " is incorrect");
	}
	
	
 //---------------------------Movie Module---------------------------------------------

	/**
	 * method name: addMovie 
	 * method desc: gets a movie class object and insert into database through save method 
	 * parameters:  Movie type - movie 
	 * return type: Movie 
	 * method type: insertion 
	 * author name: Shivani
	 */
	@Override
	public Movie addMovie(Movie movie) {
		logger.trace("Admin Service - Add Movie method");
		return movieDao.save(movie);
	}

	
	/**
	 * method name: deleteMovie 
	 * method desc: get the id of movie and delete it from database through delete by id method. 
	 * parameters:  int type - id 
	 * return type: void 
	 * method type: deletion 
	 * author name: Shivani
	 */
	@Override
	public void deleteMovie(int id) {
		logger.trace("Admin Service - Delete Movie method by id");
		Movie movie = movieDao.getById(id);
		if (movie != null) {
			movieDao.deleteById(id);
			logger.info("Movie deleted");
		} else {
			logger.error("Error has occurred");
			throw new MovieNotFoundException("Movie with this id " + id + " not found");
		}
	}
	
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
		logger.trace("Admin Service - Get movie by id method ");
		if (movie != null) {
			logger.info("Movie Found");
			return movie;
		}
		logger.error("Error occurred!");
		throw new MovieNotFoundException("Movie with id " + id + " does'nt exists.");
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
		logger.trace("Admin Service - Get movie by name method ");
		Movie movie = movieDao.getByName(name);
		if (movie != null) {
			logger.info("Movie Found");
			return movie;
		}
		logger.error("Error has occurred.");
		throw new MovieNotFoundException("Movie with name " + name + " do not exists");
	}

	/**
	 * method name: updateMovie 
	 * method desc: gets a movie class object and update this movie object into database through save method 
	 * parameters:  Movie type - movie 
	 * return type: Movie 
	 * method type: updation 
	 * author name: Shivani
	 */
	@Override
	public Movie updateMovie(Movie movie, int id) {
		logger.trace("Admin Service - Update movie by id method ");
		Movie m = movieDao.getById(id);
		if (m != null) {
			movie.setId(id);
			movieDao.save(movie);
			logger.info("Movie Updated");
			return movie;
		}
		logger.error("Error occurred");
		throw new MovieNotFoundException("Movie with id " + id + " is not present and can't be updated");
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
		logger.trace("Admin Service - Get all movies method ");
		List<Movie> movies = new ArrayList<>();
		movieDao.findAll().forEach(m -> movies.add(m));
		if (!movies.isEmpty()) {
			return movies;
		}
		logger.error("Error occurred");
		throw new MovieListEmptyException("Movie list is empty");
	}
	
  //---------------------------Theatre Module----------------------------------------------------

	/**
	 * method name: addTheatre 
	 * method desc: gets a theatre class object and insert into database through save method 
	 * parameters : Theatre type - theatre 
	 * return type: Theatre 
	 * method type: insertion 
	 * author name: Shubhi
	 */

	@Override
	public Theatre addTheatre(Theatre theatre) {
		logger.trace("Admin service layer--Add theatre method");
		return theatreDao.save(theatre);
	}
	
	/**
	 * method name: deleteTheatre 
	 * method desc: get the id of theatre and delete the theatre with the given id. 
	 * parameters : int type - id 
	 * return type: void 
	 * method type: deletion 
	 * author name: Shubhi
	 */

	@Override
	public void deleteTheatre(int id) {
		logger.trace("Admin service layer--Delete theatre by id method");
		Theatre theatre = theatreDao.getTheatreById(id);
		if (theatre != null) {
			theatreDao.deleteById(id);
			logger.info("Theatre deleted");
		} else {
			logger.error("Exception occured");
			throw new TheatreNotFoundException("Theatre with this id " + id + " do not exists");
		}
	}
	
	/**
	 * method name: updateTheatre 
	 * method desc: gets a theatre class object and update this theatre object into database through save method 
	 * parameters : Theatre type - theatre 
	 * return type: Theatre
	 * method type: updation 
	 * author name: Shubhi
	 */
	
	@Override
	public Theatre updateTheatre(Theatre theatre, int id) {
		logger.trace("Admin service layer--Update theatre by id method");
		Theatre t = theatreDao.getTheatreById(id);
		if (t != null) {
			theatre.setId(id);
			theatreDao.save(theatre);
			logger.info("Theatre with given id is updated");
			return theatre;
		}
		logger.error("Exception has ocurred");
		throw new TheatreNotFoundException("Theatre with id " + id + " is not present and can't be updated");
	}

	
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
		logger.trace("Admin service layer--Get theatre by id method");
		Theatre theatre = theatreDao.getTheatreById(id);
		if (theatre != null) {
			logger.info("Theatre with given id is fetched");
			return theatre;
		}
		logger.error("Error has ocurred");
		throw new TheatreNotFoundException("Theatre with id " + id + " does not exists!");

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
		logger.trace("Admin service layer--Get theatre by name method");
		Theatre theatre = theatreDao.getTheatreByName(name);
		if (theatre != null) {
			logger.info("Theatre with given name is fetched");
			return theatre;
		}
		logger.error("Error has ocurred");
		throw new TheatreNotFoundException("Theatre with name " + name + " does not exists!!");

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
		logger.trace("Admin service layer--View all theatres method");
		List<Theatre> theatres = new ArrayList<>();
		theatreDao.findAll().forEach(t -> theatres.add(t));
		if (!theatres.isEmpty()) {
			logger.info("Success");
			return theatres;
		} 
		logger.error("Exception Occurred!!");
		throw new TheatreListEmptyException("Theatre list is empty!!");
		
	}

	
	//-----------------------------Screen Module---------------------------------------------
	
	
	/**
	 * method name: addScreen
	 * method desc: get a Screen class object and insert into database through save method.
	 * parameters:  Screen type-screen
	 * returns:     Screen
	 * method type: insertion
	 * author name: Yashi
	 */
	@Override
	public Screen addScreen(Screen screen) {
		logger.trace("Add Screen method");
		return screenDao.save(screen);
	}
	
	/**
	 * method name: deleteScreen
	 * method desc: get a id of Screen and delete it from database through delete by id method.
	 * parameters:  int type-id
	 * returns:     void
	 * method type: deletion
	 * author name: Yashi
	 */
	@Override
	public void deleteScreen(int id) {
		logger.trace("Delete Screen method by id");
		Screen screen=screenDao.getScreenById(id);
		if(screen!= null) {
	 	screenDao.deleteById(id); 
		}
		else {
		throw new ScreenNotFoundException("Screen with id " + id + " does not exists");
		}
	}
	
	/**
	 * method name: updateScreen
	 * method desc: get a Screen class object and update it from database through save method.
	 * parameters:  Screen type-screens
	 * returns:     Screen
	 * method type: updation
	 * author name: Yashi
	 */
	@Override
	public Screen updateScreen(Screen screen) {
		logger.trace("Update Screen method");
		Screen updateScreen = screenDao.save(screen);
		if (updateScreen!=null) {
			return screenDao.save(screen);
		} else {
			throw new ScreenNotFoundException("Screen with id : " + screen.getId() + " does not exist.");
		}
	}

	/**
	 * method name: getScreen
	 * method desc: to fetch the details of screen from database through screen id by findById method.
	 * parameters:  int type-id
	 * returns:     Screen
	 * method type: retrieval
	 * author name: Yashi
	 */
	@Override
	public Screen getScreen(int id) {
		logger.trace("Get Screen by id method");
		Screen screen = screenDao.getScreenById(id);
		if (screen != null) {
			return screen;
		}
		throw new ScreenNotFoundException("Screen with id " + id + " does not exists");
	}
	
	/**
	 * method name: getAllScreen
	 * method desc: to fetch the details of screen by findAll method.
	 * parameters:  no parametrs
	 * returns:     list of screen type
	 * method type: retrieval
	 * author name: Yashi
	 */ 
	@Override
	public List<Screen> getAllScreen() {
		logger.trace("Get all Screen method");
		List<Screen> screens=new ArrayList<>();
	    screenDao.findAll().forEach(s -> screens.add(s));
	    return screens;
	}
	
	@Override
	public Screen getScreen(String name) {
		
			logger.trace("get Screen by name method");
			return screenDao.getScreenByName(name);
	}
	
	//---------------------------Show Module----------------------------------------------------


	@Override
	 public Show addShow(Show show) {
		logger.trace("Add method");
		showDao.save(show);
		return show;
	}

	@Override
	public boolean deleteShowById(int showId) {

		logger.trace("Delete method");
		showDao.deleteById(showId);
		return showDao.existsById(showId);
	}

	@Override
	public Show updateShowById(Show show) {
		logger.trace("Update method");
		showDao.save(show);
		return show;

}

}

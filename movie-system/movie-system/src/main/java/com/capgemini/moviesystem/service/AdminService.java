package com.capgemini.moviesystem.service;

import java.util.List;

import com.capgemini.moviesystem.exception.AdminNotFoundException;
import com.capgemini.moviesystem.model.Movie;
import com.capgemini.moviesystem.model.Screen;
import com.capgemini.moviesystem.model.Show;
import com.capgemini.moviesystem.model.Theatre;

public interface AdminService {
	
//-------------------------------Admin Module-------------------------------------------------
	
	public boolean getAdmin(String username, String password) throws AdminNotFoundException;
		
	
 //------------------------------Movie Module--------------------------------------------------

	public Movie addMovie(Movie movie);

	public void deleteMovie(int id);

	public Movie getMovieById(int id);

	public Movie getMovieByName(String name);

	public Movie updateMovie(Movie movie, int id);

	public List<Movie> getAllMovies();
	
	
 //-----------------------------Theatre Module----------------------------------------------------
	
	
	public Theatre addTheatre(Theatre theatre);

	public void deleteTheatre(int id);

	public Theatre updateTheatre(Theatre theatre, int id);

	public Theatre getTheatreById(int id);

	public Theatre getTheatreByName(String name);

	public List<Theatre> getAllTheatres();

//-------------------------------Screen Module-----------------------------------------------------
	
	public Screen addScreen(Screen screen);

	public void deleteScreen(int id);

	public Screen updateScreen(Screen screen);

	public Screen getScreen(int id);

	public Screen getScreen(String name);

	public List<Screen> getAllScreen();
	
//---------------------------------Show Module---------------------------------------------------------
	 
	public Show addShow(Show show);

	public boolean deleteShowById(int showId);

	public Show updateShowById(Show show);

}

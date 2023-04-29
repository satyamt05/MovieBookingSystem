package com.capgemini.moviesystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviesystem.exception.AdminNotFoundException;
import com.capgemini.moviesystem.exception.MovieListEmptyException;
import com.capgemini.moviesystem.exception.MovieNotFoundException;
import com.capgemini.moviesystem.exception.TheatreListEmptyException;
import com.capgemini.moviesystem.exception.TheatreNotFoundException;

@RestController
@ControllerAdvice
public class GlobalErrorHandler {

	Logger logger = LoggerFactory.getLogger(GlobalErrorHandler.class);
	
	//-------------------------Admin Module-----------------------------------------------------------
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Admin not found")
	@ExceptionHandler(AdminNotFoundException.class)
	public void handleAdminNotFoundException() {
		logger.trace("Error Handler--Admin Not Found");
		// Admin not found exception

	}
	
 //---------------------Movie Module---------------------------------------------------------------------

	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Movie with valid details not found")
	@ExceptionHandler(MovieNotFoundException.class)
	public void handleMovieNotFoundException() {
		logger.trace("Error Handler - Movie not found");
		// Movie Not Found Exception
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Movie list is empty")
	@ExceptionHandler(MovieListEmptyException.class)
	public void handleMovieListEmptyException() {
		logger.trace("Error Handler - Movie list empty");
		// Movie List Empty Exception
	}
	
	//----------------------------Theatre Module------------------------------------------------------------

	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Theatre with valid details not found")
	@ExceptionHandler(TheatreNotFoundException.class)
	public void handleTheatreNotFoundException() {
		logger.trace("Error Handler--Theatre Not Found");
		// Theater not found exception

	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Theatre list is empty")
	@ExceptionHandler(TheatreListEmptyException.class)
	public void handleTheatreListEmptyException() {
		logger.trace("Error Handler--Theatre List is Empty");
		// Theater list empty exception

	}

}

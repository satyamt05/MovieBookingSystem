package com.capgemini.moviesystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieListEmptyException extends RuntimeException {

	static final Logger logger=LoggerFactory.getLogger(MovieListEmptyException.class);
	
	public MovieListEmptyException(String msg) {
		super(msg);
		logger.error(msg);
	}

}

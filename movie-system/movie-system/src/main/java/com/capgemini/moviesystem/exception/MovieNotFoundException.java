package com.capgemini.moviesystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieNotFoundException extends RuntimeException {

	static final Logger logger=LoggerFactory.getLogger(MovieNotFoundException.class);
	
	public MovieNotFoundException(String msg) {
		super(msg);
		logger.error(msg);
	}

}
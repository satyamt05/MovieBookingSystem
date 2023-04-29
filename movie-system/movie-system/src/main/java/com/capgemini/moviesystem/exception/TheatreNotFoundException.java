package com.capgemini.moviesystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheatreNotFoundException extends RuntimeException {

	static final Logger logger=LoggerFactory.getLogger(TheatreNotFoundException.class);
	
	public TheatreNotFoundException(String msg) {
		super(msg);
		logger.error(msg);
	}

}
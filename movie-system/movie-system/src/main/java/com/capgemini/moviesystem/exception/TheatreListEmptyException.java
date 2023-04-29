package com.capgemini.moviesystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheatreListEmptyException extends RuntimeException {

	static final Logger logger=LoggerFactory.getLogger(TheatreListEmptyException.class);
	
	public TheatreListEmptyException(String msg) {
		super(msg);
		logger.error(msg);
	}

}

package com.capgemini.moviesystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BookingNotFoundException extends RuntimeException {
	
	static final Logger logger=LoggerFactory.getLogger(BookingNotFoundException.class);
	
	public BookingNotFoundException(String msg) {
		super(msg);
		logger.error(msg);
	}

}

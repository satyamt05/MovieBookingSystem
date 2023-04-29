package com.capgemini.moviesystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeatNotFoundException extends RuntimeException {

	static final Logger logger=LoggerFactory.getLogger(SeatNotFoundException.class);
	
	public SeatNotFoundException(String msg) {
		super(msg);
		logger.error(msg);
	}
}
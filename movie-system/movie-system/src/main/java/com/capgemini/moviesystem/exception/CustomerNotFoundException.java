package com.capgemini.moviesystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerNotFoundException extends RuntimeException {

	static final Logger logger=LoggerFactory.getLogger(CustomerNotFoundException.class);
	
	public CustomerNotFoundException(String msg) {
		super(msg);
		logger.error(msg);
	}
}



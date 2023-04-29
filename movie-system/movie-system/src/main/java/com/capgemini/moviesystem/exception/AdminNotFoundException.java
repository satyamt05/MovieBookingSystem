package com.capgemini.moviesystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminNotFoundException extends Exception {
	
	static final Logger logger=LoggerFactory.getLogger(AdminNotFoundException.class);
	
	public AdminNotFoundException(String message) {
		logger.error(message);
	}
}

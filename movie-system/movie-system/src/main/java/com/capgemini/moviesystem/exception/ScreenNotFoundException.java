package com.capgemini.moviesystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenNotFoundException extends RuntimeException {

	static final Logger logger=LoggerFactory.getLogger(ScreenNotFoundException.class);
	
	public ScreenNotFoundException(String msg) {
		super(msg);
		logger.error(msg);
	}
}

package com.capgemini.moviesystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShowNotFoundException extends Exception {
	
	static final Logger logger=LoggerFactory.getLogger(ShowNotFoundException.class);
	
	public ShowNotFoundException(String str) {
		super(str);
		logger.error(str);
	}

}

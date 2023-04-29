package com.capgemini.moviebookingsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviebookingsystem.model.Theatre;
import com.capgemini.moviebookingsystem.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@GetMapping("/theatres/{theatreId}")
	public Theatre getTheatreById(@PathVariable("theatreId") int theatreId) {
		logger.trace("Customer Controller--Get theatre by Id method");
		return customerService.getTheatreById(theatreId);

	}

	@GetMapping("/theatres/{theatreName}")
	public Theatre getTheatreByName(@PathVariable("theatreName") String theatreName) {
		logger.trace("Customer Controller--Get theatre by Name method");
		return customerService.getTheatreByName(theatreName);

	}

	@GetMapping("/theatres")
	public List<Theatre> listOfTheatres() {
		logger.trace("Customer Controller--View all theatre method");
		logger.info("Success");
		return customerService.getAllTheatres();
	}

}

package com.capgemini.moviebookingsystem.controller;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviebookingsystem.model.Theatre;
import com.capgemini.moviebookingsystem.service.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;

	@PostMapping(value = "/theatres")
	public Theatre addTheatre(@RequestBody Theatre theatre) {
		logger.trace("Admin Controller--Add theatre method");
		logger.info("Adding new theatre");
		return adminService.addTheatre(theatre);
	}

	@GetMapping("/theatres")
	public List<Theatre> listOfTheatres() {
		logger.trace("Admin Controller--View all theatre method");
		logger.info("Success");
		return adminService.getAllTheatres();
	}

	@GetMapping("/theatres/{theatreId}")
	public Theatre getTheatreById(@PathVariable("theatreId") int theatreId) {
		logger.trace("Admin Controller--Get theatre by Id method");
		return adminService.getTheatreById(theatreId);

	}

	@DeleteMapping(value = "/theatres/{theatreId}")
	public Boolean deleteTheatre(@PathVariable("theatreId") int theatreId) {
		logger.trace("Admin Controller--Delete theatre by Id method");
		adminService.deleteTheatre(theatreId);
		return true;
	}

	@PutMapping(value = "/theatres/{theatreId}")
	public Theatre updateTheatre(@RequestBody Theatre theatre, @PathVariable int theatreId) {
		logger.trace("Admin Controller--Update theatre by Id method");
		return adminService.updateTheatre(theatre, theatreId);

	}

	@GetMapping("/theatresn/{theatreName}")
	public Theatre getTheatreByName(@PathVariable("theatreName") String theatreName) {
		logger.trace("Admin Controller--Get theatre by Name method");
		return adminService.getTheatreByName(theatreName);

	}

}

package com.capgemini.moviebookingsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.moviebookingsystem.dao.TheatreRepository;
import com.capgemini.moviebookingsystem.exception.TheatreListEmptyException;
import com.capgemini.moviebookingsystem.exception.TheatreNotFoundException;
import com.capgemini.moviebookingsystem.model.Theatre;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private TheatreRepository theatreRepository;

	@Override
	public Theatre getTheatreById(int id) {
		logger.trace("Customer service layer--Get theatre by id method");
		Theatre theatre = theatreRepository.getTheatreById(id);
		if (theatre != null) {
			logger.info("Theatre with given id is fetched");
			return theatre;
		}
		logger.error("Error has ocurred");
		throw new TheatreNotFoundException("Theatre with id " + id + " does not exists");

	}

	@Override
	public Theatre getTheatreByName(String name) {
		logger.trace("Customer service layer--Get theatre by name method");
		Theatre theatre = theatreRepository.getTheatreByName(name);
		if (theatre != null) {
			logger.info("Theatre with given name is fetched");
			return theatre;
		}
		logger.error("Error has ocurred");
		throw new TheatreNotFoundException("Theatre with name " + name + " does not exists");

	}

	@Override
	public List<Theatre> getAllTheatres() {
		logger.trace("Customer service layer--View all theatres method");
		List<Theatre> theatres = new ArrayList<>();
		theatreRepository.findAll().forEach(t -> theatres.add(t));
		if (!theatres.isEmpty()) {
			logger.info("Success");
			return theatres;
		}
		logger.error("Error has ocurred.");
		throw new TheatreListEmptyException("Theatre list is empty!!");
		

	}

}

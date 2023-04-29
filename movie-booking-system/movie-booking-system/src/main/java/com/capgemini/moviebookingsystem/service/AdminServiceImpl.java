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
public class AdminServiceImpl implements AdminService {

	Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	private TheatreRepository theatreRepository;

	@Override
	public Theatre addTheatre(Theatre theatre) {
		logger.trace("Admin service layer--Add theatre method");
		return theatreRepository.save(theatre);
	}

	@Override
	public void deleteTheatre(int id) {
		logger.trace("Admin service layer--Delete theatre by id method");
		Theatre theatre = theatreRepository.getTheatreById(id);
		if (theatre != null) {
			theatreRepository.deleteById(id);
			logger.info("Theatre deleted");
		} else {
			logger.error("Exception occured");
			throw new TheatreNotFoundException("Theatre with this id " + id + " do not exists");
		}

	}

	@Override
	public Theatre updateTheatre(Theatre theatre, int id) {
		logger.trace("Admin service layer--Update theatre by id method");
		Theatre t = theatreRepository.getTheatreById(id);
		if (t != null) {
			theatre.setId(id);
			theatreRepository.save(theatre);
			logger.info("Theatre with given id is updated");
			return theatre;
		}
		logger.error("Exception has ocurred");
		throw new TheatreNotFoundException("Theatre with id " + id + " is not present and can't be updated");

	}

	@Override
	public Theatre getTheatreById(int id) {
		logger.trace("Admin service layer--Get theatre by id method");
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
		logger.trace("Admin service layer--Get theatre by name method");
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
		logger.trace("Admin service layer--View all theatres method");
		List<Theatre> theatres = new ArrayList<>();
		theatreRepository.findAll().forEach(t -> theatres.add(t));
		if (!theatres.isEmpty()) {
			logger.info("Success");
			return theatres;
		} 
		logger.error("Exception Occurred!!");
		throw new TheatreListEmptyException("Theatre list is empty!!");
		
	}

}

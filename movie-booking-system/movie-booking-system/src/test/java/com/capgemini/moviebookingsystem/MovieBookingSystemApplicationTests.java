package com.capgemini.moviebookingsystem;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.moviebookingsystem.dao.TheatreRepository;
import com.capgemini.moviebookingsystem.exception.TheatreListEmptyException;
import com.capgemini.moviebookingsystem.exception.TheatreNotFoundException;
import com.capgemini.moviebookingsystem.model.Theatre;
import com.capgemini.moviebookingsystem.service.AdminService;
import com.capgemini.moviebookingsystem.service.CustomerService;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieBookingSystemApplication.class)
class MovieBookingSystemApplicationTests {

	@Autowired
	TheatreRepository theatreRepository;

	@Autowired
	AdminService adminService;

	@Autowired
	CustomerService customerService;

	@Test
	void testTheatreNotExistById() throws TheatreNotFoundException {
		assertEquals(null, theatreRepository.getTheatreById(2000));
	}

	@Test
	void testTheatreExistById() throws TheatreNotFoundException {
		Theatre theatre = theatreRepository.getTheatreById(3953);
		assertNotNull(theatre);
	}

	@Test
	void testGetAllTheatres() throws TheatreListEmptyException {
		assertThrows(TheatreListEmptyException.class, () -> {
			customerService.getAllTheatres();
		});
	}

	@Test
	void testTheatreExistByName() throws TheatreNotFoundException {
		Theatre theatre = theatreRepository.getTheatreByName("Rev Moti");
		assertNotNull(theatre);
	}

	@Test
	void testTheatreNotExistByName() throws TheatreNotFoundException {
		assertEquals(null, theatreRepository.getTheatreByName("South Mall"));
	}

	@Test
	void testUpdateTheatre() throws TheatreNotFoundException {
		assertThrows(TheatreNotFoundException.class, () -> {
			Theatre theatre = new Theatre();
			// theatre.setId(2001);
			theatre.setName("Guru Cinema");
			theatre.setCity("Delhi");
			theatre.setManagerName("Geeta Singh");
			theatre.setManagerContact("9982745646");
			adminService.updateTheatre(theatre, 2952);
		});
	}

}

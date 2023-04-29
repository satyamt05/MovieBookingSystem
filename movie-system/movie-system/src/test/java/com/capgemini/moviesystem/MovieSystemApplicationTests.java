package com.capgemini.moviesystem;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.moviesystem.dao.IScreenDao;
import com.capgemini.moviesystem.dao.ISeatDao;
import com.capgemini.moviesystem.dao.IMovieDao;
import com.capgemini.moviesystem.dao.ITheatreDao;
import com.capgemini.moviesystem.exception.MovieListEmptyException;
import com.capgemini.moviesystem.exception.MovieNotFoundException;
import com.capgemini.moviesystem.exception.ScreenNotFoundException;
import com.capgemini.moviesystem.exception.SeatNotFoundException;
import com.capgemini.moviesystem.exception.TheatreListEmptyException;
import com.capgemini.moviesystem.exception.TheatreNotFoundException;
import com.capgemini.moviesystem.model.Movie;
import com.capgemini.moviesystem.model.Screen;
import com.capgemini.moviesystem.model.Seat;
import com.capgemini.moviesystem.model.SeatStatus;
import com.capgemini.moviesystem.model.Theatre;
import com.capgemini.moviesystem.service.AdminService;
import com.capgemini.moviesystem.service.CustomerService;

@SpringBootTest(classes = MovieSystemApplication.class)
class MovieSystemApplicationTests {

	@Autowired
	AdminService adminService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	IMovieDao movieDao;
	
	@Autowired
	ITheatreDao theatreDao;
	
	@Autowired
	IScreenDao screenDao;
	
	@Autowired
	ISeatDao seatDao;
	
	//---------------------------------Movie module---------------------------------------
	
	@Test
	void testMovietNotExistById() throws MovieNotFoundException {
		assertEquals(null, movieDao.getById(3002));
	}

	@Test
	void testMovieExistById() throws MovieNotFoundException {
		Movie movie = movieDao.getById(3001);
		assertNotNull(movie);
	}

	@Test
	void testMovieNotExistByName() throws MovieNotFoundException {
		assertEquals(null, movieDao.getByName("Wariz"));
	}

	@Test
	void testMovietExistByName() throws MovieNotFoundException {
		Movie movie = movieDao.getByName("Action Again2");
		assertNotNull(movie);
	}

	@Test
	void testUpdateMovie() throws MovieNotFoundException {
		assertThrows(MovieNotFoundException.class, () -> {
			Movie movie = new Movie();
			movie.setName("Action Replay");
			movie.setDirector("Shekar");
			movie.setGenre("Drama");
			movie.setLanguage("Hindi");
			movie.setLength(3);
			String str = "2019-03-31";
			Date releaseDate = Date.valueOf(str);// converting string into sql date
			movie.setReleaseDate(releaseDate);
			adminService.updateMovie(movie, 3952);
		});
	}

	@Test
	void testGetAllMovies() throws MovieListEmptyException {
		assertThrows(MovieListEmptyException.class, () -> {
			customerService.getAllMovies();
		});
	}

	@Test
	void testDeleteMovie() throws MovieNotFoundException {
		assertThrows(MovieNotFoundException.class, () -> {
			Movie movie = adminService.getMovieById(3009);
			if (movie.getName() != null) {
				adminService.deleteMovie(movie.getId());
			}
		});
	}
	
  //------------------------------Theatre Module---------------------------------------------------

	@Test
	void testTheatreNotExistById() throws TheatreNotFoundException {
		assertEquals(null, theatreDao.getTheatreById(2004));
	}

	@Test
	void testTheatreExistById() throws TheatreNotFoundException {
		Theatre theatre = theatreDao.getTheatreById(2002);
		assertNotNull(theatre);
	}

	@Test
	void testGetAllTheatres() throws TheatreListEmptyException {
		assertThrows(TheatreListEmptyException.class, () -> {
			customerService.getAllTheatres();
		});
	}

	@Test
	void testTheatreNotExistByName() throws TheatreNotFoundException {
		assertEquals(null, theatreDao.getTheatreByName("South Mall"));
	}

	@Test
	void testTheatreExistByName() throws TheatreNotFoundException {
		Theatre theatre = theatreDao.getTheatreByName("Cinema Plex");
		assertNotNull(theatre);
	}

	@Test
	void testUpdateTheatre() throws TheatreNotFoundException {
		assertThrows(TheatreNotFoundException.class, () -> {
			Theatre theatre = new Theatre();
			theatre.setName("Guru Cinema");
			theatre.setCity("Delhi");
			theatre.setManagerName("Geeta Singh");
			theatre.setManagerContact("9982745646");
			adminService.updateTheatre(theatre, 2005);
		});
	}

	@Test
	void testDeleteTheatre() throws TheatreNotFoundException {
		assertThrows(TheatreNotFoundException.class, () -> {
			Theatre theatre = adminService.getTheatreById(2008);
			if (theatre.getName() != null) {
				adminService.deleteTheatre(theatre.getId());
			}
		});
	}

  //-------------------------Screen Module--------------------------------------------------
	
	@Test
	void testScreenNotExistById() throws ScreenNotFoundException {
		assertEquals(null, screenDao.getScreenById(-1));
	}

	@Test
	void testScreenExistById() throws ScreenNotFoundException {
		Screen screen = screenDao.getScreenById(1);
		assertNotNull(screen);

	}

	@Test
	void testScreenNotExistByName() throws ScreenNotFoundException {
		assertEquals(null, screenDao.getScreenByName("Scre56"));
	}

	@Test
	void testScreenExistByName() throws ScreenNotFoundException {
		Screen screen = screenDao.getScreenByName("Screen2");
		assertNotNull(screen);

	}

  //----------------------------Seat Module-----------------------------------------------
	

		@Test
		void testSeatNotExistById() throws SeatNotFoundException {
			assertEquals(Optional.empty(), seatDao.findById(25));
		}

		@Test
		void testSeatExistById() throws SeatNotFoundException {
			Optional<Seat> seat = seatDao.findById(1);
			assertNotNull(seat);
		}

		@Test
		void testAllSeats() {
			List<Seat> seatlist = seatDao.findAll();
			assertNotNull(seatlist);
		}

		@Test
		void testAddSeat() {
			Seat seat = new Seat(1, SeatStatus.valueOf("AVAILABLE"), 1200.00);
			Seat Seat = seatDao.save(seat);
			assertNotNull(Seat);
		}
}


		

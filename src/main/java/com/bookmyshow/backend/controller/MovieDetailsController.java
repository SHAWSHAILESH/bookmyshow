package com.bookmyshow.backend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.backend.auth.JwtTokenUtil;
import com.bookmyshow.backend.dao.models.Cinema;
import com.bookmyshow.backend.dao.models.CinemaMovieSlotMapping;
import com.bookmyshow.backend.dao.models.CinemaSeat;
import com.bookmyshow.backend.dao.models.Movie;
import com.bookmyshow.backend.dao.models.MovieDetailDTO;
import com.bookmyshow.backend.dao.models.Ticket;
import com.bookmyshow.backend.dao.models.UserDao;
import com.bookmyshow.backend.dao.repository.CinemaMovieSlotMappingRepository;
import com.bookmyshow.backend.dao.repository.CinemaRepository;
import com.bookmyshow.backend.dao.repository.CinemaSeatRepository;
import com.bookmyshow.backend.dao.repository.MovieRepository;
import com.bookmyshow.backend.dao.repository.SlotRepository;
import com.bookmyshow.backend.dao.repository.TicketRepository;
import com.bookmyshow.backend.dao.repository.UserRepository;

@RestController
public class MovieDetailsController {
	private static final Logger logger = Logger.getLogger(MovieDetailsController.class);
	
    @Autowired
    private  TicketRepository ticketRepository;
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CinemaRepository cinemaRepository;
    
    @Autowired
    private CinemaSeatRepository cinemaSeatRepository;
    
    @Autowired
    private SlotRepository slotRepository;
    
    @Autowired
    private CinemaMovieSlotMappingRepository cinemaMovieSlotMappingRepository;
    
	@Autowired
	private UserDetailsService jwtUserDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
    
    @Transactional
	@GetMapping("/movies/{city_id}")
    public List<Movie> findAllMoviesByCity(@PathVariable(value = "city_id") int city_id) {
		List<CinemaMovieSlotMapping> cinemaMovieSlotMappings = cinemaMovieSlotMappingRepository.findAllWithDescriptionQuery(city_id);
    	ArrayList<Integer> movie_ids = new ArrayList<Integer>();
    	for(CinemaMovieSlotMapping cinemaMap : cinemaMovieSlotMappings) {
    		movie_ids.add(cinemaMap.getMovie().getId());
    	}
		List<Movie> movies = movieRepository.findByIdIn(movie_ids);
		logger.info(movies);
		return movies;
    }
	
    @Transactional
	@GetMapping("/movies/{city_id}/{movie_id}")
    public List<MovieDetailDTO> findDetailsByMovie(@PathVariable(value = "city_id") int city_id, 
    		@PathVariable(value = "movie_id") int movie_id) {
		List<CinemaMovieSlotMapping> cinemaMovieSlotMappings = cinemaMovieSlotMappingRepository.findAllWithDescriptionQuery(city_id, movie_id);
    	ArrayList<MovieDetailDTO> movie_details = new ArrayList<MovieDetailDTO>();
    	for(CinemaMovieSlotMapping cinemaMap : cinemaMovieSlotMappings) {
    		MovieDetailDTO movie = new MovieDetailDTO();
    		movie.setCinemaId(cinemaMap.getCinema().getId());
    		movie.setCinemaName(cinemaMap.getCinema().getName());
    		movie.setMovieName(cinemaMap.getMovie().getTitle());
    		movie.setSlot_id(cinemaMap.getSlot().getId());
    		movie.setShowtime(cinemaMap.getSlot().getShowtime());
    		movie_details.add(movie);
    	}
		logger.info(movie_details);
		return movie_details;
    }
	
    @Transactional
	@GetMapping("/movies/{cinema_id}/{slot_id}/seats")
    public List<CinemaSeat> findSeatsByMovie(@PathVariable(value = "cinema_id") int cinema_id,
    		@PathVariable(value = "slot_id") int slot_id) {
		List<CinemaSeat> cinemaSeats = cinemaSeatRepository.findAllWithDescriptionQuery(cinema_id, slot_id);
		return cinemaSeats;
    }
	
    @Transactional
	@GetMapping("/movies/ticket/{seat_id}")
    public Ticket findSeatsByMovie(HttpServletRequest request, @PathVariable(value = "seat_id") int seat_id) throws Exception {
    	final String requestTokenHeader = request.getHeader("Authorization");
    	String jwtToken = requestTokenHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
		UserDao user = userRepository.findByName(username);
		CinemaSeat cinemaSeat = cinemaSeatRepository.findBySeat_Id(seat_id);
		if(cinemaSeat.getStatus().equalsIgnoreCase("CLOSED")) {
			throw new Exception("SEAT ALREADY BOOKED");
		}
		Ticket ticket = new Ticket();
		ticket.setUser(user);
		ticket.setCinemaSeat(cinemaSeat);
		ticket.setStatus("SUCCESS");
		cinemaSeat.setStatus("CLOSED");
		cinemaSeatRepository.save(cinemaSeat);
		ticketRepository.save(ticket);
		return ticket;
    }
	
}

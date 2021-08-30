package com.bookmyshow.backend.dao.models;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class MovieDetailDTO {
	private int cinemaId;
	private String cinemaName;
	private String movieName;
	private int availableSeats;
	private int slot_id;
	public int getSlot_id() {
		return slot_id;
	}
	public void setSlot_id(int slot_id) {
		this.slot_id = slot_id;
	}
	private Timestamp showtime;
	
	public MovieDetailDTO(int cinemaId, String cinemaName, String movieName, int availableSeats, Timestamp showtime) {
		super();
		this.cinemaId = cinemaId;
		this.cinemaName = cinemaName;
		this.movieName = movieName;
		this.availableSeats = availableSeats;
		this.showtime = showtime;
	}
	public MovieDetailDTO(String cinemaName, String movieName, int availableSeats, Timestamp showtime) {
		super();
		this.cinemaName = cinemaName;
		this.movieName = movieName;
		this.availableSeats = availableSeats;
		this.showtime = showtime;
	}
	
	public MovieDetailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public Timestamp getShowtime() {
		return showtime;
	}
	public void setShowtime(Timestamp showtime) {
		this.showtime = showtime;
	}
}

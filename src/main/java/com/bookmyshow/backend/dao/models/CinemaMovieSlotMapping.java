package com.bookmyshow.backend.dao.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cinemamovie")
public class CinemaMovieSlotMapping{
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne()
	@JoinColumn(name="cinema_id", referencedColumnName = "id")
	private Cinema cinema;
	@ManyToOne()
	@JoinColumn(name="slot_id", referencedColumnName = "id")
	private Slot slot;
	@ManyToOne()
	@JoinColumn(name="movie_id", referencedColumnName = "id")
	private Movie movie;
	public CinemaMovieSlotMapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public CinemaMovieSlotMapping(Cinema cinema, Slot slot, Movie movie) {
		super();
		this.cinema = cinema;
		this.slot = slot;
		this.movie = movie;
	}

}

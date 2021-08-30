package com.bookmyshow.backend.dao.models;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    @OneToMany(mappedBy="movie")
    @JsonIgnore
    private Set<CinemaMovieSlotMapping> cinemaMovieSlotMappings;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<CinemaMovieSlotMapping> getCinemaMovieSlotMappings() {
		return cinemaMovieSlotMappings;
	}
	public void setCinemaMovieSlotMappings(Set<CinemaMovieSlotMapping> cinemaMovieSlotMappings) {
		this.cinemaMovieSlotMappings = cinemaMovieSlotMappings;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", cinemaMovieSlotMappings=" + cinemaMovieSlotMappings
				 +"]";
	}
	public Movie(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
    
}

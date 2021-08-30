package com.bookmyshow.backend.dao.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cinema")
public class Cinema {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    
    @ManyToOne()
    @JoinColumn(name="city_id", referencedColumnName = "id")
    private City city;
    
	@OneToMany(mappedBy="cinema")
	@JsonIgnore
    private Set<CinemaMovieSlotMapping> cinemaMovieSlotMappings;
    
    @OneToMany(mappedBy="cinema")
    @JsonIgnore
    private Set<CinemaSeat> cinemaSeats;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<CinemaMovieSlotMapping> getCinemaMovieSlotMappings() {
		return cinemaMovieSlotMappings;
	}

	public void setCinemaMovieSlotMappings(Set<CinemaMovieSlotMapping> cinemaMovieSlotMappings) {
		this.cinemaMovieSlotMappings = cinemaMovieSlotMappings;
	}

	public Set<CinemaSeat> getCinemSeats() {
		return cinemaSeats;
	}

	public void setCinemSeats(Set<CinemaSeat> cinemSeats) {
		this.cinemaSeats = cinemSeats;
	}

	public Cinema(int id, String name, City city, Set<CinemaMovieSlotMapping> cinemaMovieSlotMappings,
			Set<CinemaSeat> cinemSeats) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.cinemaMovieSlotMappings = cinemaMovieSlotMappings;
		this.cinemaSeats = cinemSeats;
	}

	public Cinema() {
		super();
		// TODO Auto-generated constructor stub
	}



}

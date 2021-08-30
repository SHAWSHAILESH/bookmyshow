package com.bookmyshow.backend.dao.models;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "slot")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Timestamp showtime;
    @OneToMany(mappedBy="slot")
    @JsonIgnore
    private Set<CinemaMovieSlotMapping> cinemaMovieSlotMappings;
    @OneToMany(mappedBy="slot")
    @JsonIgnore
    private Set<CinemaSeat> cinemaSeats;
	public Slot(int id, Timestamp showtime) {
		super();
		this.id = id;
		this.showtime = showtime;
	}
	public Slot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getShowtime() {
		return showtime;
	}
	public void setShowtime(Timestamp showtime) {
		this.showtime = showtime;
	}
}

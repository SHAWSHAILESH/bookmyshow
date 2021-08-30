package com.bookmyshow.backend.dao.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cinemaseat")
public class CinemaSeat {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seat_id;
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name="cinema_id", referencedColumnName = "id")
    private Cinema cinema;
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name="slot_id", referencedColumnName = "id")
	private Slot slot;
	private String seat_no;
	private String status;
	@OneToOne(mappedBy = "cinemaSeat")
	@JsonIgnore
	private Ticket ticket;
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
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
	public String getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public CinemaSeat(int seat_id, Cinema cinema, Slot slot, String seat_no, String status, Ticket ticket) {
		super();
		this.seat_id = seat_id;
		this.cinema = cinema;
		this.slot = slot;
		this.seat_no = seat_no;
		this.status = status;
		this.ticket = ticket;
	}
	public CinemaSeat() {
		super();
		// TODO Auto-generated constructor stub
	}
}

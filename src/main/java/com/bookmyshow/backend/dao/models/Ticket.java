package com.bookmyshow.backend.dao.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticket_id;
    @ManyToOne()
	@JoinColumn(name="user_id", referencedColumnName = "id")
    private UserDao user;
    @OneToOne()
    @JoinColumn(name="seat_id", referencedColumnName = "seat_id")
    private CinemaSeat cinemaSeat;
    private String status;
	public Ticket(int ticket_id, UserDao user, CinemaSeat cinemaSeat,String status) {
		super();
		this.ticket_id = ticket_id;
		this.user = user;
		this.cinemaSeat = cinemaSeat;
		this.status = status;
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public UserDao getUser() {
		return user;
	}
	public void setUser(UserDao user) {
		this.user = user;
	}
	public CinemaSeat getCinemaSeat() {
		return cinemaSeat;
	}
	public void setCinemaSeat(CinemaSeat cinemaSeat) {
		this.cinemaSeat = cinemaSeat;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    

}

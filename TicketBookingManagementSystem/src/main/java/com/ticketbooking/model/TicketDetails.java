package com.ticketbooking.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TICKET_DTLS")
public class TicketDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TICKET_ID")
	private Integer ticketId;
	
	@Column(name="NO_OF_TICKETS")
	private Integer noOfTickets;
	
	@Column(name="JOUNEY_DATE")
	private Date journeyDate;
	
	@Column(name="START_POINT")
	private String startPoint;
	
	@Column(name="END_POINT")
	private String endPoint;
	
	@Column(name="FARE")
	private Integer fare;
	
	@Column(name="START_TIME")
	private Time startTime;
	
	@ManyToOne
	private UserDetails userDetails;
	
	@ManyToOne
	private BusDetails busDetails;
	
	@OneToMany(mappedBy="ticketDetails")
	private List<BusSeatsDetails> busSeatsDetails;
	
	

    
	public Integer getTicketId() {
		return ticketId;
	}


	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}


	public Integer getNoOfTickets() {
		return noOfTickets;
	}


	public void setNoOfTickets(Integer noOfTickets) {
		this.noOfTickets = noOfTickets;
	}


	public Date getJourneyDate() {
		return journeyDate;
	}


	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}


	public String getStartPoint() {
		return startPoint;
	}


	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}


	public String getEndPoint() {
		return endPoint;
	}


	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}


	public Integer getFare() {
		return fare;
	}


	public void setFare(Integer fare) {
		this.fare = fare;
	}


	public Time getStartTime() {
		return startTime;
	}


	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}


	public BusDetails getBusDetails() {
		return busDetails;
	}


	public void setBusDetails(BusDetails busDetails) {
		this.busDetails = busDetails;
	}


	public List<BusSeatsDetails> getBusSeatsDetails() {
		return busSeatsDetails;
	}


	public void setBusSeatsDetails(List<BusSeatsDetails> busSeatsDetails) {
		this.busSeatsDetails = busSeatsDetails;
	}


	public UserDetails getUserDetails() {
		return userDetails;
	}


	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}




}
	
	
	
	



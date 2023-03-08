package com.ticketbooking.dto;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.ticketbooking.model.BusDetails;

public class TicketDto {
	
	private Integer userId;
	private Integer busId;
	private Integer noOfTickets;
	private Date journeyDate;
	private String startPoint;
	private String endPoint;
	private Integer fare;
	private Time startTime;
	private List<String> seats;
	
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public Integer getBusId() {
		return busId;
	}
	public void setBusId(Integer busId) {
		this.busId = busId;
	}
	public List<String> getSeats() {
		return seats;
	}
	public void setSeats(List<String> seats) {
		this.seats = seats;
	}
	
	
	
	
	
	
	
	
	
	
}

package com.ticketbooking.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BUS_SEATS_DTLS")
public class BusSeatsDetails {
	
	@Id
	@Column(name="BUS_SEATS_ID")
	private Integer busSeatsId;
	
	@Column(name="SEAT_NUMBER")
	private String seatNumber;
	
	@Column(name="SEAT_TYPE")
	private String seatType;
	
	@Column(name="BOOK_STATUS")
	private String bookingStatus;
	
	@Column(name="CANCEL_STATUS")
	private String cancelStatus;		
	
	@ManyToOne
	private TicketDetails ticketDetails;
	
	@ManyToOne
	private BusDetails busDetails;

	public Integer getBusSeatsId() {
		return busSeatsId;
	}

	public void setBusSeatsId(Integer busSeatsId) {
		this.busSeatsId = busSeatsId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}


	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}


	public TicketDetails getTicketDetails() {
		return ticketDetails;
	}

	public void setTicketDetails(TicketDetails ticketDetails) {
		this.ticketDetails = ticketDetails;
	}

	

	public BusDetails getBusDetails() {
		return busDetails;
	}

	public void setBusDetails(BusDetails busDetails) {
		this.busDetails = busDetails;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(String cancelStatus) {
		this.cancelStatus = cancelStatus;
	}
	
	
	

}

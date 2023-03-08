package com.ticketbooking.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BUS_DTLS")
public class BusDetails {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column (name="BUS_ID")
	 private Integer busId;
	 
	 @Column(name="BUS_NAME")
	 private String busName;
	 
	 @Column(name="BUS_NUMBER")
	 private String busNumber;
	 
	 @Column(name="START_POINT")
	 private String startPoint;
	 
	 @Column(name="END_POINT")
	 private String endPoint;
	 
	 @Column(name="START_TIME")
	 private String startTime;
	 
	 @Column (name="TOTAL_SEATS")
	 private Integer totalSeats;
	 
	 @Column (name="BUS_TYPE")
	 private String busType;
	 
	 @OneToMany(mappedBy="busDetails")
	 private List<BusSeatsDetails> busSeatsDetails;

	 @OneToMany(mappedBy="busDetails")
	 private List<TicketDetails> ticketDetails;
	 

	public List<TicketDetails> getTicketDetails() {
		return ticketDetails;
	}

	public void setTicketDetails(List<TicketDetails> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
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
	
	

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	

	public List<BusSeatsDetails> getBusSeatsDetails() {
		return busSeatsDetails;
	}

	public void setBusSeatsDetails(List<BusSeatsDetails> busSeatsDetails) {
		this.busSeatsDetails = busSeatsDetails;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}
	
	
	 
	     
}

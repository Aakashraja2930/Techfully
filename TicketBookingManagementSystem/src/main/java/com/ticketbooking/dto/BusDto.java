package com.ticketbooking.dto;


public class BusDto {

     private Integer busId;
	 private String busName;
	 private String startPoint;
	 private String endPoint;
	 private String startTime;
	 private Integer totalSeats;
	 private String busType;

     

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


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	


	public Integer getTotalSeats() {
		return totalSeats;
	}


	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}



	public String getBusType() {
		return busType;
	}


	public void setBusType(String busType) {
		this.busType = busType;
	}

	
}

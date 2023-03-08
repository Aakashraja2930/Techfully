package com.ticketbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ticketbooking.dto.TicketCancelDto;
import com.ticketbooking.dto.TicketDto;
import com.ticketbooking.model.BusDetails;
import com.ticketbooking.model.BusSeatsDetails;
import com.ticketbooking.model.TicketDetails;
import com.ticketbooking.model.UserDetails;
import com.ticketbooking.repo.BusRepo;
import com.ticketbooking.repo.BusSeatsRepo;
import com.ticketbooking.repo.TicketRepo;
import com.ticketbooking.repo.UserRepo;
import com.ticketbooking.util.ResponseData;
import com.ticketbooking.util.TicketBookingConstant;

@Service

public class TicketService {
	
	@Autowired
	private BusRepo busRepo;

	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private BusSeatsRepo busSeatsRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	
	public ResponseData<String> bookTicket(TicketDto ticketDto) {
		ResponseData<String> response = new ResponseData<>();
		UserDetails user = userRepo.findByUserId(ticketDto.getUserId());
		if(user == null) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage(TicketBookingConstant.USER_NOT_FOUND);
			return response;
		}
		
		BusDetails busData = busRepo.findByBusId(ticketDto.getBusId());
		
		if(busData != null) {
			TicketDetails  ticketData = new TicketDetails();
			ticketData.setBusDetails(busData);
			ticketData.setStartTime(ticketDto.getStartTime());
			ticketData.setJourneyDate(ticketDto.getJourneyDate());
			ticketData.setStartPoint(ticketDto.getStartPoint());
			ticketData.setEndPoint(ticketDto.getEndPoint());
			ticketData.setNoOfTickets(ticketDto.getNoOfTickets());
			ticketData.setFare(ticketDto.getFare());
			ticketData.setUserDetails(user);
			ticketData = ticketRepo.save(ticketData);
			for(String seatNumer : ticketDto.getSeats()) {
		    BusSeatsDetails busSeatsDetails = busSeatsRepo.findBySeatNumber(seatNumer);
		    if(!"Y".equals(busSeatsDetails.getBookingStatus())) {
		    busSeatsDetails.setBookingStatus("Y");
		    busSeatsDetails.setCancelStatus("N");
		    busSeatsDetails.setTicketDetails(ticketData);
		    busSeatsRepo.save(busSeatsDetails);
		    }
			}
			response.setCode(HttpStatus.OK.value());
			response.setMessage(TicketBookingConstant.TICKETS_BOOKING_SUCCESS);
			
		}else {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage(TicketBookingConstant.BUS_NOT_FOUND);
		}
		return response;
		
	}

	public ResponseData<String> cancelTicket(Integer ticketId, Integer userId) {
		ResponseData<String> response = new ResponseData<>();
		UserDetails user = userRepo.findByUserId(userId);
		if(user == null) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage(TicketBookingConstant.USER_NOT_FOUND);
			return response;
		}
		
		TicketDetails ticketDetails = ticketRepo.findByticketIdAndUserDetails(ticketId, user);
		if(ticketDetails !=null) {
			for(BusSeatsDetails busSeats : ticketDetails.getBusSeatsDetails()) {
				busSeats.setBookingStatus("N");
				busSeats.setCancelStatus("Y");
				busSeatsRepo.save(busSeats);
			}
			
			response.setCode(HttpStatus.OK.value());
			response.setMessage(TicketBookingConstant.TICKETS_CANCELLED);
			
		}else {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage(TicketBookingConstant.TICKET_NOT_FOUND);
		}
		return response;
		
		}
		


	public ResponseData<TicketDto> showTicket(Integer ticketId) {
		ResponseData<TicketDto> response = new ResponseData<TicketDto>();
		TicketDto ticketDto = null;
		List<String> seatNumberList = new ArrayList<>();
		TicketDetails ticketDetails = ticketRepo.findByticketId(ticketId);
		if(ticketDetails != null) {
			ticketDto = new TicketDto();
			ticketDto.setBusId(ticketDetails.getBusDetails().getBusId());
			ticketDto.setNoOfTickets(ticketDetails.getBusSeatsDetails().size());
			ticketDto.setStartPoint(ticketDetails.getStartPoint());
			ticketDto.setEndPoint(ticketDetails.getEndPoint());
			ticketDto.setFare(ticketDetails.getFare());
			ticketDto.setJourneyDate(ticketDetails.getJourneyDate());
			ticketDto.setStartTime(ticketDetails.getStartTime());
			ticketDto.setSeats(null);
			
			for(BusSeatsDetails busSeats : ticketDetails.getBusSeatsDetails()) {
				seatNumberList.add(busSeats.getSeatNumber());
			}
			ticketDto.setSeats(seatNumberList);
			response.setData(ticketDto);
		}
		return response;
	}
	
	
	
	
	
	
	
	
	
	

}

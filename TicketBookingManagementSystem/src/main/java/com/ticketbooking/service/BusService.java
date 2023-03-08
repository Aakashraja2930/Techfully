package com.ticketbooking.service;

//import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ticketbooking.dto.BusDto;
import com.ticketbooking.model.BusDetails;
import com.ticketbooking.model.BusSeatsDetails;
import com.ticketbooking.repo.BusRepo;
import com.ticketbooking.repo.BusSeatsRepo;
import com.ticketbooking.util.ResponseData;
import com.ticketbooking.util.TicketBookingConstant;

@Service
public class BusService {
	
@Autowired
private BusRepo busRepo;

@Autowired
private BusSeatsRepo busSeatsRepo;
	
	
public ResponseData<String> addBus(BusDto busDto) {
	 ResponseData<String> response = new ResponseData<>();
		BusDetails busData = null;
		if(busDto !=null) {
		
		busData = new BusDetails();
		busData.setBusName(busDto.getBusName());
		busData.setBusType(busDto.getBusType());
		busData.setTotalSeats(busDto.getTotalSeats());//total seats
		busData.setEndPoint(busDto.getEndPoint());
		busData.setStartPoint(busDto.getStartPoint());
		busData.setStartTime(busDto.getStartTime());
		busRepo.save(busData);
		addSeats(busDto.getTotalSeats());
		response.setCode(HttpStatus.OK.value());
		response.setMessage(TicketBookingConstant.SUCCESS_MESSAGE);
	}else {
		response.setMessage(TicketBookingConstant.FIELDS_EMPTY_MESSAGE);
		response.setCode(HttpStatus.BAD_REQUEST.value());
		
	}
		return  response;
}
   private void addSeats(Integer totalSeats) {
	   BusSeatsDetails busSeates = new BusSeatsDetails();
	   for(int i=0; i<totalSeats; i++) {
		   busSeates.setSeatNumber("ST-"+i);
		   busSeates.setSeatType("normal");
		   busSeates.setBookingStatus("N");
		   busSeatsRepo.save(busSeates);
		   
	   }
	
}
public ResponseData<List<BusDto>> getAllBusDetails() {
	ResponseData<List<BusDto>> response = new ResponseData<List<BusDto>>();
	List<BusDto> busDtoList = new ArrayList<>();
	BusDto busDto = null;
	List<BusDetails> busDetailsList = busRepo.findAll();
	for(BusDetails busDetails : busDetailsList ) {
		busDto = new BusDto();
		busDto.setBusId(busDetails.getBusId());
		busDto.setBusName(busDetails.getBusName());
		busDto.setBusType(busDetails.getBusType());
		busDto.setEndPoint(busDetails.getEndPoint());
		busDto.setStartPoint(busDetails.getStartTime());
		busDto.setTotalSeats(busDetails.getTotalSeats());
		busDto.setStartTime(busDetails.getStartTime());
		busDtoList.add(busDto);
		response.setData(busDtoList);
	}
	
	return response;
}
public ResponseData<BusDto> getBusDetailsById(Integer busId) {
	 ResponseData<BusDto> response = new  ResponseData<BusDto>();
	BusDetails busDetails = busRepo.findByBusId(busId);
	BusDto busDto = null;
	if(busDetails != null) {
		busDto = new BusDto();
		busDto.setBusId(busDetails.getBusId());
		busDto.setBusName(busDetails.getBusName());
		busDto.setBusType(busDetails.getBusType());
		busDto.setEndPoint(busDetails.getEndPoint());
		busDto.setStartPoint(busDetails.getStartTime());
		busDto.setTotalSeats(busDetails.getTotalSeats());
		busDto.setStartTime(busDetails.getStartTime());
	}
	return response;
}
}

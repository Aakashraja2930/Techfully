package com.ticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.dto.TicketCancelDto;
import com.ticketbooking.dto.TicketDto;
import com.ticketbooking.service.TicketService;
import com.ticketbooking.util.ResponseData;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
@Autowired
private TicketService ticketService;
	
	@PostMapping("/booking")
	public ResponseData<String> bookTicket(@RequestBody TicketDto ticketDto) {
		return ticketService.bookTicket(ticketDto);
	}
	
	@DeleteMapping("/cancel")
	public ResponseData<String> cancelTicket(@RequestParam Integer ticketId, @RequestHeader Integer userId){
		
		
		return ticketService.cancelTicket(ticketId, userId);
	}
	
	@GetMapping("/getTicketDetailsById")
	public ResponseData<TicketDto> showTickets(@RequestParam Integer ticketId ){
		
		
		return ticketService.showTicket(ticketId);
	}
	
	
}

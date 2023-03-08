package com.ticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.dto.BusDto;
import com.ticketbooking.service.BusService;
import com.ticketbooking.util.ResponseData;

@RestController
@RequestMapping("/bus")
public class BusController {

	@Autowired
	private BusService busService;
	
@PostMapping("/add")
public ResponseData<String> addBus(@RequestBody BusDto busDto) {
	
	return busService.addBus(busDto);
	
}

@GetMapping("/getAllBusDetails")
public  ResponseData<List<BusDto>> getAllBusDetails() {
	return busService.getAllBusDetails();
	
}

@GetMapping("/getBusDetailsById")
public  ResponseData<BusDto> getBusDetailsById(@RequestParam Integer busId) {
	return busService.getBusDetailsById(busId);
	
}
	
	
}

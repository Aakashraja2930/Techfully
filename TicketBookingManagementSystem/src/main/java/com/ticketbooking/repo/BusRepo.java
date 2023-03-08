package com.ticketbooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.model.BusDetails;

@Repository
public interface BusRepo extends JpaRepository<BusDetails, Integer> {
	
	public BusDetails  findByBusId(Integer busId);

	public BusDetails findBybusType(String busType);
	
	
	

}

package com.ticketbooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.model.BusSeatsDetails;

@Repository
public interface BusSeatsRepo extends JpaRepository<BusSeatsDetails, Integer>{
	
	public BusSeatsDetails  findBySeatNumber(String seatNumber);
    public List<BusSeatsDetails> findBybusSeatsId(Integer busSeatsId);

}

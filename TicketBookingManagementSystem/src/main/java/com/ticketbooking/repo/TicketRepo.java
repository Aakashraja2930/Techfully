package com.ticketbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.model.TicketDetails;
import com.ticketbooking.model.UserDetails;

@Repository
public interface TicketRepo extends JpaRepository<TicketDetails , Integer>{

	
	public TicketDetails findByticketId(Integer ticketId);
	
	public TicketDetails findByticketIdAndUserDetails(Integer ticketId, UserDetails userDetails);
	
	
	
	
}

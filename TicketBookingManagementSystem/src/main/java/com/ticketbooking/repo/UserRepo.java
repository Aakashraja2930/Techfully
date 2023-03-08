package com.ticketbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.model.UserDetails;
@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer>{
	
	
	public UserDetails findByuserName(String userName);
	
	public UserDetails findByUserId(Integer userId);
	

}

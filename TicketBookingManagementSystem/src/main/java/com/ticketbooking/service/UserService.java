package com.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ticketbooking.dto.LoginDto;
import com.ticketbooking.dto.UserDto;
import com.ticketbooking.model.UserDetails;
import com.ticketbooking.repo.UserRepo;
import com.ticketbooking.util.ResponseData;
import com.ticketbooking.util.TicketBookingConstant;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public ResponseData<String> saveUserData(UserDto userDto) {
		ResponseData<String> response = new ResponseData<String>();
		UserDetails user = userRepo.findByuserName(userDto.getUserName());
		if(user==null) {
		UserDetails UserData =new UserDetails();
		UserData.setAge(userDto.getAge());
		UserData.setEmailId(userDto.getEmailId());
		UserData.setGender(userDto.getGender());
		UserData.setName(userDto.getName());
		UserData.setPassword(userDto.getPassword());
		UserData.setPhoneNumber(userDto.getPhoneNumber());
		UserData.setProofNumber(userDto.getProofNumber());
		UserData.setProofType(userDto.getProofType());
		UserData.setUserName(userDto.getUserName());
		userRepo.save(UserData);
		
		response.setCode(HttpStatus.OK.value());
		response.setMessage(TicketBookingConstant.USER_SIGNUP_SUCCESS);
		
		}
		else {
			
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage(TicketBookingConstant.USER_EXIST);
			
			
		}
		
		
		return response;
		
	}

	public ResponseData<Integer> userLogin(LoginDto loginDto) {
		ResponseData<Integer> response = new ResponseData<Integer>();
		UserDetails user = userRepo.findByuserName(loginDto.getUserName());
		
		if(user.getPassword().equals(loginDto.getPassword())) {
			response.setData(user.getUserId());
			response.setCode(HttpStatus.OK.value());
			response.setMessage(TicketBookingConstant.LOGIN_SUCCESS_MESSAGE);
			
		}
		
		else {
			
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage(TicketBookingConstant.LOGIN_FAILURE_MESSAGE);
		}
		return response;
	}
}

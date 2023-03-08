package com.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.dto.LoginDto;
import com.ticketbooking.dto.UserDto;
import com.ticketbooking.service.UserService;
import com.ticketbooking.util.ResponseData;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	public ResponseData<Integer> userLogin(LoginDto loginDto) {	
	
	return userService.userLogin(loginDto);
	}
	
	
	
	@PostMapping("/signup")
	public ResponseData<String> saveUserData(UserDto userDto) {
		
		return userService.saveUserData(userDto);
		
	}

	
	
	
	
	
}

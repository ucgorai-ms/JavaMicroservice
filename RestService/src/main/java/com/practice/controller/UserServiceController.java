package com.practice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.bean.UserBean;

import com.practice.service.impl.UserServiceImpl;

@RestController
public class UserServiceController {
	
	private UserServiceImpl userService;
	

	public UserServiceController(UserServiceImpl userService) {
		super();
		this.userService = userService;
	}


	@GetMapping(path = "/users")
	public List<UserBean> getUsers(){
		return userService.getUsers();
		
	}
	
	@GetMapping("/user/{id}")
	public UserBean getUser(@PathVariable int id) {
		return userService.getUser(id);
	}

}

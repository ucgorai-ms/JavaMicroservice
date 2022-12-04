package com.practice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return this.userService.getUsers();
		
	}
	
	@GetMapping("/user/{id}")
	public UserBean getUser(@PathVariable int id) {
		return this.userService.getUser(id);
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody UserBean user) {
		
		this.userService.addUser(user);
	}

}

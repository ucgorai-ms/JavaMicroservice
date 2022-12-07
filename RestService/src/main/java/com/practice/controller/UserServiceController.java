package com.practice.controller;

import java.net.URI;
import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practice.bean.UserBean;
import com.practice.custom.exception.UserNotFoundException;
import com.practice.service.impl.UserServiceImpl;

import jakarta.validation.Valid;


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
		
		UserBean user = this.userService.getUser(id);
		
		if (user == null) {
			
			throw new UserNotFoundException(String.format("User with the id %s is not availble", id));
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody UserBean user) {
		
		UserBean savedUser = this.userService.addUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

}

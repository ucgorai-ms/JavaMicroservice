package com.practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.custom.exception.UserNotFoundException;
import com.practice.entity.PostEntity;
import com.practice.entity.UserEntity;
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
	public List<UserEntity> getUsers(){
		return userService.getUsers();
		
	}
	
	@GetMapping("/user/{id}")
	public UserEntity getUser(@PathVariable int id) {
		
		Optional<UserEntity> user = this.userService.getUser(id);
		
		if (user.isEmpty()) {
			
			throw new UserNotFoundException(String.format("User with the id %s is not availble", id));
		}
		return user.get();
	}
	
	@PostMapping("/users")
	//public ResponseEntity<Object> createUser(@Valid @RequestBody UserEntity user) {
	public void createUser(@Valid @RequestBody UserEntity user) {
		
		this.userService.createUser(user);
		
		/*
		 * URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		 * .path("/{id}") .buildAndExpand(savedUser.getId()) .toUri();
		 * 
		 * return ResponseEntity.created(location).build();
		 */
	}
	

	@GetMapping("/user/{id}/posts")
	public List<PostEntity> getPostsByUser(@PathVariable int id) {
		
		Optional<UserEntity> user = this.userService.getUser(id);
		
		if (user.isEmpty()) {
			
			throw new UserNotFoundException(String.format("User with the id %s is not availble", id));
		}
		return user.get().getPosts();
	}
	
	@PostMapping("/users/{id}/posts")
	public void createPostsByUser(@PathVariable int id, @RequestBody PostEntity post) {
		System.out.println("I am here ----------------------->");
		
		this.userService.createPostByUser(id, post);
		
	}

}

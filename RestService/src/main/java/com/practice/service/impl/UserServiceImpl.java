package com.practice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.custom.exception.UserNotFoundException;
import com.practice.entity.PostEntity;
import com.practice.entity.UserEntity;
import com.practice.repository.PostRepository;
import com.practice.repository.UserRepositiry;

@Component
public class UserServiceImpl {
	
	private UserRepositiry userRepository;
	
	
	private PostRepository postrepository;
	
	public UserServiceImpl (UserRepositiry userRepository, PostRepository postrepository) {
		this.userRepository=userRepository;
		this.postrepository=postrepository;
	}
	


	public List<UserEntity> getUsers() {
		
		return userRepository.findAll();
	}


	public Optional<UserEntity> getUser(int id) {
		
		return this.userRepository.findById(id);
	}
	
	public void createUser(UserEntity user) {
		
		this.userRepository.save(user);
	}
	
	public void createPostByUser (int id, PostEntity post) {
		
		Optional<UserEntity> user = this.getUser(id);
		
		if (user.isEmpty()) {
			
			throw new UserNotFoundException(String.format("User with the id %s is not availble", id));
		}
		
		post.setUser(user.get());
		
		this.postrepository.save(post);	
	}

}

package com.practice.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.practice.bean.UserBean;
import com.practice.entity.UserEntity;
import com.practice.repository.UserRepositiry;

@Component
public class UserServiceImpl {
	
	private static List<UserBean> userList = new ArrayList<UserBean>();
	private static int userCount = 0;
	
	private UserRepositiry userRepository;
	
	public UserServiceImpl (UserRepositiry userRepository) {
		this.userRepository=userRepository;
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


}

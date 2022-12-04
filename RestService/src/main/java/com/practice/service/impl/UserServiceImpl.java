package com.practice.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.practice.bean.UserBean;

@Component
public class UserServiceImpl {
	
	private static List<UserBean> userList = new ArrayList<UserBean>();
	private static int userCount = 0;
	
	static 
	{
		userList.add(new UserBean(++userCount,"Uma", LocalDate.now().minusYears(32)));
		userList.add(new UserBean(++userCount,"Twinkle", LocalDate.now().minusYears(21)));
		userList.add(new UserBean(++userCount,"Dipti", LocalDate.now().minusYears(1).minusMonths(3).minusDays(3)));
	}


	public List<UserBean> getUsers() {
		
		return userList;
	}


	public UserBean getUser(int id) {
		
		return userList.stream().filter(user -> user.getId() == id).findFirst().get();
	}
	
	public void addUser(UserBean user) {
		
		user.setId(++userCount);
		userList.add(user);
	}


}

package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.bean.UserBean;
import com.practice.entity.UserEntity;

public interface UserRepositiry extends JpaRepository<UserEntity, Integer>{

	//void save(UserBean user);

}

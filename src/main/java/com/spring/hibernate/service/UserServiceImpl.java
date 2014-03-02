package com.spring.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.dao.UserDAO;
import com.spring.hibernate.model.User;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao;
	
	@Override
	
	@Transactional
	public void insertUser(User user) {
			userDao.insertUser(user);
	}

	
	@Override
	@Transactional
	public List<User> getUserView() {
		
		// User class with the Role he is having 
		//User Form Mapping
		
		return userDao.getUserView();
		
		
	}
	
	
	/*
	@Override
	@Transactional
	public List<User> getSingleUserView() {
		
		// User class with the Role he is having 
		// User Form Mapping call DAO 
		return userDao.getUserView();
		
	}
	
	*/

}

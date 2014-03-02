package com.spring.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.dao.UserDAO;
import com.spring.hibernate.model.User;

public class AdminServiceImpl implements AdminService{

	@Autowired
	private UserDAO userDao;
	
	@Override
	@Transactional
	public void activateUser(int userId) {
			userDao.activateUser(userId);
	}

	
	@Transactional
	@Override
	public List<User> findUserByEmailId(String emailId) {
		
		return userDao.findUserByEmailId(emailId);
	}

	@Transactional
	@Override
	public User findUserByUserId(int userId) {
		return userDao.findUserByUserId(userId);
		
	}

	@Transactional
	@Override
	public void deactivateUser(int userId) {
		userDao.deactivateUser(userId);
		
	}

	@Transactional
	@Override
	public void resetPassword(String userName, String password) {
		userDao.resetPassword(userName,password);		
	}




	@Override
	@Transactional
	public List<User> getUserViewEdit(int userId) {
		// TODO Auto-generated method stub
		return null;
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

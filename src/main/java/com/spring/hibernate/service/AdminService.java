package com.spring.hibernate.service;

import java.util.List;



import com.spring.hibernate.model.User;

public interface AdminService {
	
	
	public List<User> findUserByEmailId(String emailId);
	
	public User findUserByUserId(int userId);
	
	public void activateUser(int userId);
	
	public void deactivateUser(int userId);
	
	public void resetPassword(String userName,String password);
	
	public List<User> getUserViewEdit(int userId);
	
	public List<User> getUserView();
}

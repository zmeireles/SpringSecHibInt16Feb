package com.spring.hibernate.dao;

import java.util.List;

import com.spring.hibernate.model.Role;
import com.spring.hibernate.model.User;

public interface UserDAO {
	
	
	public void insertUser(User user);
	public User getUser(String USERNAME);
	
	public List<User> getUserView();
	public void deactivateUser(int userId);
	public void activateUser(int userId);
	public void resetPassword(String userName, String password);
	public List<User> findUserByEmailId(String emailId);
	public User findUserByUserId(int userId);
	
	//public String deleteUser(int userId);
	
	//public List<User> getUserViewEdit(int userId);

}

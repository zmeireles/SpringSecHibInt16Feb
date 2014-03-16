package com.spring.hibernate.service;

import java.util.List;



import com.spring.hibernate.model.User;

public interface UserService {
	
	
	public void insertUser(User user);
	public List<User> getUserView();
	public void updateUser(User user);
	public User getUser(int id);
	public void deleteUser(int id);
	
	//public String deleteUser(int userId);
	
	//public List<User> getUserViewEdit(int userId);

}

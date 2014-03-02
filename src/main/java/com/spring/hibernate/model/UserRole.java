package com.spring.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="user_role")
public class UserRole {
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
    @PrimaryKeyJoinColumn
	private User user;
	private int roleid;
	 private int user_id;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
		
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	public UserRole(int id, User user, int roleid, int user_id) {
		super();
		this.id = id;
		this.user = user;
		this.roleid = roleid;
		this.user_id = user_id;
	}
	public UserRole() {
		
	}
	
}

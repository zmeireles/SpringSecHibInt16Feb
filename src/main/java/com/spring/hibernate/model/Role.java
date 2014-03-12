package com.spring.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	private Set<UserRole> users = new HashSet<UserRole>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<UserRole> getUsers() {
		return users;
	}
	public void setUsers(Set<UserRole> users) {
		this.users = users;
	}
	
	public int toIntRole(){
		if(this.name.equals("ROLE_ADMIN"))
			return 1;
		else if(this.name.equals("ROLE_USER"))
			return 2;
		return 3;
	}
	
}

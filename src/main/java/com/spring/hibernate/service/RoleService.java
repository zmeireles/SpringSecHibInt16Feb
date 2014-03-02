package com.spring.hibernate.service;

import java.util.List;

import com.spring.hibernate.model.Role;

public interface RoleService {

	public List<Role> findRoleByName(String name);
	
	public void createRole(Role role);
	public List<Role> getRoleView();

	public void deleteRole(String name);
	
}

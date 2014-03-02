package com.spring.hibernate.dao;

import java.util.List;

import com.spring.hibernate.model.Role;

public interface RoleDAO {

	public List<Role> findRoleByName(String name);
	public void createRole(Role role);
	public List<Role> getRoleView();
	public void deleteRole(String name);
}

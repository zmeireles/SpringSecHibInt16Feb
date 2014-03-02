package com.spring.hibernate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.dao.RoleDAO;
import com.spring.hibernate.dao.UserDAO;
import com.spring.hibernate.model.Role;

public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDao;
	
	@Transactional
	@Override
	public List<Role> findRoleByName(String name) {
				
		return roleDao.findRoleByName(name);
	}

	@Transactional
	@Override
	public void createRole(Role role) {
		roleDao.createRole(role);
		
	}

	@Transactional
	@Override
	public List<Role> getRoleView() {
		
		return roleDao.getRoleView();
	}
	@Transactional
	@Override
	public void deleteRole(String role) {
		roleDao.deleteRole(role);
		
	}

}

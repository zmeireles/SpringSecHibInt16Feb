package com.spring.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.dao.UtilDao;

public class UtilServiceImpl implements UtilService{

	@Autowired
	private UtilDao utilDao;
	
	@Override
	@Transactional
	public void initUsers() {
			utilDao.initUserTable();
	}

	@Override
	@Transactional
	public void initDepartments() {
			utilDao.initDepartmentTable();
	}
	
	

}

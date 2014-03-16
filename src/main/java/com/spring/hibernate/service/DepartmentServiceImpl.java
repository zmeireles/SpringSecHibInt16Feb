package com.spring.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.dao.DepartmentDao;
import com.spring.hibernate.model.Department;

public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	@Transactional
	public void insertDepartment(Department dep) {
		departmentDao.insertDepartment(dep);
	}

	@Override
	@Transactional
	public List<Department> getDepartments() {
		return departmentDao.getDepartments();
	}

	@Override
	@Transactional
	public void updateDepartment(Department dep) {
		departmentDao.updateDepartment(dep);
	}

	@Override
	@Transactional
	public Department getDepartment(int id) {
		return departmentDao.getDepartment(id);
	}
	
	@Override
	@Transactional
	public void deleteDepartment(int id) {
		departmentDao.deleteDepartment(id);
	}
}

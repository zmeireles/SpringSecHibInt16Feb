package com.spring.hibernate.dao;

import java.util.List;

import com.spring.hibernate.model.Department;

public interface DepartmentDao {
	
	public void insertDepartment(Department dep);
	public List<Department> getDepartments();
	public void updateDepartment(Department dep);
	public Department getDepartment(int id);
	public void deleteDepartment(int id);

}

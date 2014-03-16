package com.spring.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.hibernate.model.Department;

public class DepartmentDaoImpl implements DepartmentDao{

	private static final Logger logger = Logger.getLogger(DepartmentDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertDepartment(Department dep) {
		this.sessionFactory.getCurrentSession().save(dep);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartments() {
		return this.sessionFactory.getCurrentSession().createQuery("from Department order by name").list();
	}

	@Override
	public void updateDepartment(Department dep) {
		this.sessionFactory.getCurrentSession().update(dep);
	}
	
	@Override
	public Department getDepartment(int id){
		return (Department)this.sessionFactory.getCurrentSession().get(Department.class, id);
	}

	@Override
	public void deleteDepartment(int id) {
		
		Query deleteItemsQuery = this.sessionFactory.getCurrentSession().createQuery("DELETE Department WHERE id =:id");
	    deleteItemsQuery.setParameter("id", id);
	    deleteItemsQuery.executeUpdate();
	}
	
}

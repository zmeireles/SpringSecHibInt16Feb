package com.spring.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.hibernate.model.Role;


public class RoleDAOImpl implements RoleDAO {

	private static final Logger logger = Logger.getLogger(RoleDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Role> findRoleByName(String name) {
		List<Role> roleL = new ArrayList<Role>();
		try {
			logger.info("inside RoleDAOImpl:findRoleByName" + name);
			roleL = sessionFactory.getCurrentSession()
					.createQuery("from roles r where r.name like :name")
					.setParameter("name", "%"+name+"%").list();
		} catch (Exception ex) {
			logger.info("returning RoleDAOImpl:findRoleByName"
					+ ex.toString());
		}
		return roleL;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoleView() {
		return this.sessionFactory.getCurrentSession().createQuery("from roles").list();
	}

	@Override
	public void createRole(Role role) {
		try{
			logger.info("inside RoleDAOImpl:createRole");
			this.sessionFactory.getCurrentSession().save(role);
			
		}
		catch (Exception ex) {
			logger.info("returning RoleDAOImpl:createRole"
					+ ex.toString());	
		}
		
	}
	@Override
	public void deleteRole(String name) {
		try{
			logger.info("inside RoleDAOImpl:deleteRole"+name);
			Query deleteItemsQuery = this.sessionFactory.getCurrentSession().createQuery("DELETE roles WHERE name =:name");
		    deleteItemsQuery.setParameter("name", name);
		    deleteItemsQuery.executeUpdate();
			
			logger.info("exiting RoleDAOImpl:deleteRole");
		}
		catch (Exception ex) {
			logger.info("returning RoleDAOImpl:deleteRole"
					+ ex.toString());	
		}
		
	}

}

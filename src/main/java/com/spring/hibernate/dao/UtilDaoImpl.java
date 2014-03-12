package com.spring.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.hibernate.model.Department;
import com.spring.hibernate.model.Role;
import com.spring.hibernate.model.User;
import com.spring.hibernate.model.UserRole;

public class UtilDaoImpl implements UtilDao{

	private static final Logger logger = Logger.getLogger(UtilDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void initUserTable(){
		try{
			//first delete all users, roles and user roles
			logger.info("Deleting users");
			sessionFactory.getCurrentSession().createQuery("delete user").executeUpdate();
			logger.info("Deleting roles");
			sessionFactory.getCurrentSession().createQuery("delete role").executeUpdate();
			logger.info("Deleting user roles");
			sessionFactory.getCurrentSession().createQuery("delete user_role").executeUpdate();
			
			logger.info("creating users and roles");
			//then create default users: john/admin and jane/user
			Role role = new Role();
			User user = new User();
			//role and user admin
			role.setName("ROLE_ADMIN");
			user.setActive(true);
			user.setEmailId("john@gmail.com");
			user.setFirstName("John");
			user.setLastName("Doe");
			user.setPassword("21232f297a57a5a743894a0e4a801fc3");
			user.setUserName("john");
			UserRole userRole = new UserRole();
			userRole.setRole(role);
			userRole.setUser(user);
			
			role.getUsers().add(userRole);
			
			sessionFactory.getCurrentSession().persist(role);
			user.getRoles().add(userRole);
			sessionFactory.getCurrentSession().persist(user);
			
			role=new Role();
			user =new User();
			
			//role and regular user
			role.setName("ROLE_USER");
			user.setActive(true);
			user.setEmailId("jane@gmail.com");
			user.setFirstName("Jane");
			user.setLastName("Doe");
			user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");
			user.setUserName("jane");
			userRole = new UserRole();
			userRole.setRole(role);
			userRole.setUser(user);
			role.getUsers().add(userRole);
			
			sessionFactory.getCurrentSession().persist(role);
			user.getRoles().add(userRole);
			sessionFactory.getCurrentSession().persist(user);
			System.out.println("Users initialized");
		}catch (Exception e){
			logger.info("Error initializing users: " +e.toString());
		}
	}
	
	@Override
	public void initDepartmentTable(){
		try{
			//first delete all departments
			logger.info("Deleting departments");
			List<Department> deps = sessionFactory.getCurrentSession().createQuery(
					"from Department").list();
			
			for(Department d:deps){
				for(User u:d.getUsers()){
					u.setDepartment(null);
					sessionFactory.getCurrentSession().merge(u);
				}
				sessionFactory.getCurrentSession().delete(d);
			}
			
			//sessionFactory.getCurrentSession().createQuery("delete department").executeUpdate();
			
			Department dep = new Department();
			dep.setName("Human Resources");
			sessionFactory.getCurrentSession().persist(dep);
			
			dep = new Department();
			dep.setName("Financial");
			sessionFactory.getCurrentSession().persist(dep);
			
			dep = new Department();
			dep.setName("Administration");
			sessionFactory.getCurrentSession().persist(dep);
			
			dep = new Department();
			dep.setName("Production");
			sessionFactory.getCurrentSession().persist(dep);
			
			logger.info("creating departments");
			System.out.println("Departments initialized");
		}catch (Exception e){
			logger.info("Error initializing users: " +e.toString());
		}
	}

}

package com.spring.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.hibernate.model.Role;
import com.spring.hibernate.model.User;

public class UserDAOImpl implements UserDAO{

	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserView() {
		return this.sessionFactory.getCurrentSession().createQuery("from user").list();
	}

	
	public User getUser(String USERNAME) {
		logger.info("inside UserDAOImpl:getUser"+USERNAME);
        List<User> userList = new ArrayList();        
        String hql = "from user u where u.userName = :userName";
     
        userList = sessionFactory.getCurrentSession().createQuery(hql).setParameter("userName", USERNAME).list();
     
        logger.info("userList UserDAOImpl:getUser"+userList.size());
        if (userList.size() > 0){
        	logger.info("returning UserDAOImpl:getUser"+userList.size());
        	logger.info("get is UserDAOImpl:getUser"+userList.get(0).toString());
            return  userList.get(0);
        }
        else{
        	logger.info("else returning UserDAOImpl:getUser"+userList.size());
            return null;   }

    }

	
	@Override
	public void deactivateUser(int userId) {
		/*Session session = this.sessionFactory.getCurrentSession();
		Query q = (Query) session.createQuery("from User where userId= :UserId");
		q.setParameter("UserId", userId);
		User result = (User)((Criteria) q).list().get(0);
		*/try{
		User result=(User) this.sessionFactory.getCurrentSession().createQuery("from user where userId= :userId").setParameter("userId", userId).list();
		result.setActive(0);
		this.sessionFactory.getCurrentSession().update(result);}
		catch(Exception ex){
			logger.info("else returning UserDAOImpl:deactivateUser"+ex.toString());
		}
	}

	@Override
	public void activateUser(int userId) {
		/*Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User where userId= :UserId");
		q.setParameter("UserId", userId);
		User result = (User)q.list().get(0);*/
		
		try{
			User result=(User) this.sessionFactory.getCurrentSession().createQuery("from user where userId= :userId").setParameter("userId", userId).list();
		
		result.setActive(1);
		this.sessionFactory.getCurrentSession().update(result);}
	catch(Exception ex){
		logger.info("else returning UserDAOImpl:activateUser"+ex.toString());
	}
		
	}

	@Override
	public void resetPassword(String userName, String password) {
		/*Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User where userName= :UserName");
		q.setParameter("UserName", userName);
		User result = (User)q.list().get(0);*/
		
		try{
			User result=(User) this.sessionFactory.getCurrentSession().createQuery("from user where userName= :UserName").setParameter("userName", userName).list();
		
		result.setPassword(password);
		this.sessionFactory.getCurrentSession().update(result);
		}catch(Exception ex){
			logger.info("else returning UserDAOImpl:resetPassword"+ex.toString());
		}
	}

	@Override
	public List<User> findUserByEmailId(String emailId) {
		
		return this.sessionFactory.getCurrentSession().createQuery("from user where emailId ='" +emailId + "'").list();
		
	}

	@Override
	public User findUserByUserId(int userId) {
		return (User)this.sessionFactory.getCurrentSession().createQuery("from user where userId =" + userId).list().get(0);
		
	}
	

}

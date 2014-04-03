package com.spring.hibernate.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.PasswordEncoderParser;

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
        System.out.println(hql + USERNAME);
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
	public User getUser(int id) {
		return (User) this.sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		System.out.println("updateUser: user id:"+user.getUserId());
		this.sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void deactivateUser(int userId) {
		/*Session session = this.sessionFactory.getCurrentSession();
		Query q = (Query) session.createQuery("from User where userId= :UserId");
		q.setParameter("UserId", userId);
		User result = (User)((Criteria) q).list().get(0);
		*/try{
			User result=(User) this.sessionFactory.getCurrentSession().createQuery("from user where userId= :userId").setParameter("userId", userId).list().get(0);
		result.setActive(false);
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
			User result=(User) this.sessionFactory.getCurrentSession().createQuery("from user where userId= :userId").setParameter("userId", userId).list().get(0);
		
		result.setActive(true);
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
			User result=(User) this.sessionFactory.getCurrentSession().createQuery("from user where userName= :UserName").setParameter("UserName", userName).list().get(0);
		
		result.setPassword(md5(password));
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

	@Override
	public void deleteUser(int id) {
		Query deleteItemsQuery = this.sessionFactory.getCurrentSession().createQuery("DELETE user WHERE id =:id");
	    deleteItemsQuery.setParameter("id", id);
	    deleteItemsQuery.executeUpdate();
		
	}
	

	 public  String md5(String input) {
         
	        String md5 = null;
	         
	        if(null == input) return null;
	         
	        try {
	             
	        //Create MessageDigest object for MD5
	        MessageDigest digest = MessageDigest.getInstance("MD5");
	         
	        //Update input string in message digest
	        digest.update(input.getBytes(), 0, input.length());
	 
	        //Converts message digest value in base 16 (hex) 
	        md5 = new BigInteger(1, digest.digest()).toString(16);
	 
	        } catch (NoSuchAlgorithmException e) {
	 
	            e.printStackTrace();
	        }
	        return md5;
	    }
	
}

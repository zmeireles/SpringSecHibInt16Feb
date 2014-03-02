package com.spring.hibernate.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.spring.hibernate.dao.UserDAO;
import com.spring.hibernate.dao.UserDAOImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * A custom {@link UserDetailsService} where user information
 * is retrieved from a JPA repository
 */
@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {
	private static final Logger logger = Logger.getLogger(CustomUserDetailsService.class);
	@Autowired
	private UserDAO userDAO;
	/**
	 * Returns a populated {@link UserDetails} object. 
	 * The username is first retrieved from the database and then mapped to 
	 * a {@link UserDetails} object.
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("inside CustomUserDetailsService:loadUserByUsername");
		try {
			com.spring.hibernate.model.User domainUser = userDAO.getUser(username);
			logger.info("domainUser CustomUserDetailsService:loadUserByUsername");
			//logger.info("role 1CustomUserDetailsService:loadUserByUsername"+domainUser.getRole());
			//logger.info("role CustomUserDetailsService:loadUserByUsername"+domainUser.getRole().toString());
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			
			return new User(
					domainUser.getUserName(), 
					domainUser.getPassword().toLowerCase(),
					enabled,
					accountNonExpired,
					credentialsNonExpired,
					accountNonLocked,
					getAuthorities(domainUser.getUserRole().getRoleid()));
			
		} catch (Exception e) {
			logger.info("inside catch CustomUserDetailsService:loadUserByUsername"+e.toString());
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * Retrieves a collection of {@link GrantedAuthority} based on a numerical role
	 * @param role the numerical role
	 * @return a collection of {@link GrantedAuthority
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		logger.info("inside CustomUserDetailsService:getAuthorities"+authList.size());
		return authList;
	}
	
	
	/**
	 * Converts a numerical role to an equivalent list of roles
	 * @param role the numerical role
	 * @return list of roles as as a list of {@link String}
	 */
	public List<String> getRoles(Integer role) {
		logger.info("inside CustomUserDetailsService:getRoles"+role);
		List<String> roles = new ArrayList<String>();
		
		if (role.intValue() == 1) {
			roles.add("ROLE_USER");
			roles.add("ROLE_ADMIN");
			
		} else if (role.intValue() == 2) {
			roles.add("ROLE_USER");
		}else if (role.intValue() == 3) {
			roles.add("ROLE_CSR");
		}
		logger.info("outside CustomUserDetailsService:getRoles");
		return roles;
	}
	
	/**
	 * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
	 * @param roles {@link String} of roles
	 * @return list of granted authorities
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		logger.info("inside CustomUserDetailsService:getGrantedAuthorities");
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		logger.info("outside CustomUserDetailsService:getGrantedAuthorities");
		return authorities;
	}
}

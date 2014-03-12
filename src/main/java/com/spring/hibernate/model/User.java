package com.spring.hibernate.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "user")
public class User {

	@Id
	@Column(name = "USERID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "CONTACTNU")
	private String contactNu;

	@Column(name = "EMAILID")
	private String emailId;

	@Column(name = "LASTLOGINDT")
	private Date lastLogin;

	@Column(name = "SUPERVISOR")
	private int supId;

	@Column(name = "ACTIVE")
	private boolean active;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Set<UserRole> roles = new HashSet<UserRole>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	private Department department;

	// getters and setters

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNu() {
		return contactNu;
	}

	public void setContactNu(String contactNu) {
		this.contactNu = contactNu;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getSupId() {
		return supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User(int userId, String userName, String password, String firstName,
			String lastName, String address, String contactNu, String emailId,
			Date lastLogin, int supId, boolean active) {

		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactNu = contactNu;
		this.emailId = emailId;
		this.lastLogin = lastLogin;
		this.supId = supId;
		this.active = active;
	}

	public User() {
		super();
	}
	
	/**
	 * returns the ROLE_ADMIN if it has this role, ROLE_USER if it has this role 
	 * but not the admin role, and another role if neither of the previous are found
	 * @return
	 */
	public Role obtainTopRole(){
		
		for(UserRole uRole:this.roles){
			if(uRole.getRole().getName().equals("ROLE_ADMIN"))
				return uRole.getRole();
		}
		for(UserRole uRole:this.roles){
			if(uRole.getRole().getName().equals("ROLE_ISER"))
				return uRole.getRole();
		}
		for(UserRole uRole:this.roles)
			return uRole.getRole();
		
		return null;
	}

}

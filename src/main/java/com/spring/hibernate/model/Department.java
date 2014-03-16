package com.spring.hibernate.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable{

	private static final long serialVersionUID = 3480720705399070061L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id = 0;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	private Set<User> users;

	// getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (this == obj)
			return true;
		else if (obj instanceof Department) {
			Department to = (Department) obj;
			if (to.getId() == this.id)
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		
		return id.hashCode();
	}

}

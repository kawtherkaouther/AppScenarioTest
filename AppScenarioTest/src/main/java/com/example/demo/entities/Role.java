package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.JoinColumn;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Role implements Serializable{
	
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;
	private String role;
	@ManyToMany(mappedBy = "roles")
	private Collection<AppUser> users;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable (name = "roles_privileges", 
	joinColumns = @JoinColumn (name = "role_id", referencedColumnName = "idRole"), 
	inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
	private Collection<Previlige> previliges;


	public Long getIdRole() {
		return idRole;
	}


	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Collection<AppUser> getUsers() {
		return users;
	}


	public void setUsers(Collection<AppUser> users) {
		this.users = users;
	}


	public Collection<Previlige> getPreviliges() {
		return previliges;
	}


	public void setPriviliges(Collection<Previlige> previliges) {
		this.previliges = previliges;
	}  
	

	
}

package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("http://localhost:4200")
@Entity
@Table(name = "user")
public class AppUser implements Serializable{



		/**
	 * 
	 */
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idUser;
		private String firstName;
		private String lastName;
		@NotNull
		@Column(unique = true, nullable = false)
		private String login;
		
	    // desactivation de @JsonIgnore obligatoire ici
	    private String password;
	    private boolean active = true;
		@Column(unique = true)
		private String email;
		
		
		@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(name = "users_roles",
		joinColumns = @JoinColumn (name = "login", referencedColumnName = "login"), 
		inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "role"))
		private Collection<Role> roles = new ArrayList<>();



		public Long getIdUser() {
			return idUser;
		}


		public void setIdUser(Long idUser) {
			this.idUser = idUser;
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


		public String getLogin() {
			return login;
		}


		public void setLogin(String login) {
			this.login = login;
		}

		
		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public boolean isActive() {
			return active;
		}


		public void setActive(boolean active) {
			this.active = active;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public Collection<Role> getRoles() {
			return roles;
		}


		public void setRoles(Collection<Role> roles) {
			this.roles = roles;
		}


		public AppUser(String firstName, String lastName, @NotNull String login, String password, String email) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.login = login;
			this.password = password;
			this.email = email;
		}


		public AppUser() {
			super();
			// TODO Auto-generated constructor stub
		}

		

}

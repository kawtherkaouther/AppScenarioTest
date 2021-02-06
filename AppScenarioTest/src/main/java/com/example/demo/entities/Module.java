package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Module {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nom;
	    private String description;
	    private Date dateCreation;
	    private Double tauxModule;
	   
	    @OneToMany
	    private List<Scenario> scenarios;
	   
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Date getDateCreation() {
			return dateCreation;
		}
		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}
		public Double getTauxModule() {
			return tauxModule;
		}
		public void setTauxModule(Double tauxModule) {
			this.tauxModule = tauxModule;
		}
		
		
	
	
		
		
		@Override
		public String toString() {
			return "Module [id=" + id + ", nom=" + nom + ", description=" + description + ", dateCreation="
					+ dateCreation + ", tauxModule=" + tauxModule + 
					 "]";
		}
		
		
		public Module(String nom, String description, Date dateCreation, Double tauxModule,List<Scenario> scenarios) {
			
			this.nom = nom;
			this.description = description;
			this.dateCreation = dateCreation;
			this.tauxModule = tauxModule;
			this.scenarios = scenarios;
			
		}
		public Module() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Module(Long id, String nom, String description, Date dateCreation, Double tauxModule,
				List<Scenario> scenarios) {
			super();
			this.id = id;
			this.nom = nom;
			this.description = description;
			this.dateCreation = dateCreation;
			this.tauxModule = tauxModule;
		
			this.scenarios = scenarios;
		}
		

}

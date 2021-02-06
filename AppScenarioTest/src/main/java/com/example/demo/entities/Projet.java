package com.example.demo.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Entity
public class Projet {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long  projetId;
	    private String nom;
	    private String description;
	    private Date dateCreation;
	    private Double tauxProjet;
	   
	    
	  
	    
		public Long getProjetId() {
			return  projetId;
		}
		public void setProjetId(Long  projetId ) {
			this. projetId  =  projetId ;
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
		public Double getTauxProjet() {
			return tauxProjet;
		}
		public void setTauxProjet(Double tauxProjet) {
			this.tauxProjet = tauxProjet;
		}
		
		
	
		
		@Override
		public String toString() {
			return "Projet [id=" +  projetId  + ", nom=" + nom + ", description=" + description + ", dateCreation="
					+ dateCreation + ", tauxProjet=" + tauxProjet + "]";
		}
		
		
		
		
		public Projet(Long projetId, String nom, String description, Date dateCreation, double tauxProjet) {
			super();
			// TODO Auto-generated constructor stub
			this.projetId = projetId;
			this.nom = nom;
			this.description = description;
			this.dateCreation = dateCreation;
			this.tauxProjet = tauxProjet;
			
		}
		public Projet( String nom, String description) {
			// TODO Auto-generated constructor stub
			
			this.nom = nom;
			this.description = description;
		}
		public Projet() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	    

	    
}

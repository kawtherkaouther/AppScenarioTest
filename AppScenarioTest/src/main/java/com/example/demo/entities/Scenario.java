package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Scenario {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nom;
	    private String object;
	    private String type_s;
	    private String req;
	    private String per_test;
	    private String exp_rest;
	    private String etat;
	    @ManyToOne
	    private Module module;
	   
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
		public String getObject() {
			return object;
		}
		public void setObject(String object) {
			this.object = object;
		}
		public String getType_s() {
			return type_s;
		}
		public void setType_s(String type_s) {
			this.type_s = type_s;
		}
		public String getReq() {
			return req;
		}
		public void setReq(String req) {
			this.req = req;
		}
		public String getPer_test() {
			return per_test;
		}
		public void setPer_test(String per_test) {
			this.per_test = per_test;
		}
		public String getExp_rest() {
			return exp_rest;
		}
		public void setExp_rest(String exp_rest) {
			this.exp_rest = exp_rest;
		}
		public String getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat = etat;
		}
		
		@Override
		public String toString() {
			return "Scenario [id=" + id + ", nom=" + nom + ", object=" + object + ", type_s=" + type_s + ", req=" + req
					+ ", per_test=" + per_test + ", exp_rest=" + exp_rest + ", etat=" + etat + "]";
		}
		public Scenario(String nom, String object, String type_s, String req, String per_test, String exp_rest, String etat
				,Module module) {
			super();
			this.nom = nom;
			this.object = object;
			this.type_s = type_s;
			this.req = req;
			this.per_test = per_test;
			this.exp_rest = exp_rest;
			this.etat = etat;
			this.module = module;
		
		}
		public Scenario() {
			super();
			// TODO Auto-generated constructor stub
		}
	    

}

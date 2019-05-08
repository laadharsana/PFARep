package org.sid.Entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Specialte")
public class Specialite implements Serializable {
	@Id @GeneratedValue 
	private Long id_specialte ;
	private String nom_specialte;
	private String description;
	public Specialite(String nom_specialte) {
		super();
		this.nom_specialte = nom_specialte;
	}
	public Specialite() {
		super();
		
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId_specialte() {
      return id_specialte;
	}
	public void setId_specialte(Long id_specialte) {
		this.id_specialte = id_specialte;
	}
	
	public String getNom_specialte() {
		return nom_specialte;
	}
	public void setNom_specialte(String nom_specialte) {
		this.nom_specialte = nom_specialte;
	}

}
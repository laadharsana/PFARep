package org.sid.Entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Section")
public class Section implements Serializable{
	@Id @GeneratedValue 
	private Long id_section ;
	private String nom_section;
	private String description ; 
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Section(String nom_section) {
		super();
		this.nom_section = nom_section;
	}
	public Section() {
		super();
		
	}
	public Long getId_section() {
		return id_section;
	}
	public void setId_section(Long id_section) {
		this.id_section = id_section;
	}
	public String getNom_section() {
		return nom_section;
	}
	public void setNom_section(String nom_section) {
		this.nom_section = nom_section;
	}
	

}
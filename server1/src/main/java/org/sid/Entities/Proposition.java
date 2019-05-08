package org.sid.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Proposition")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Proposition implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id_proposition ;
    private String titre ; 
    private String description ; 
    private String technologie ;
    private String fichier;
    @Temporal(TemporalType.DATE)
    private Date date_depot;
	public Proposition() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Proposition(Long id_proposition, String titre, String description, String technologie, String fichier,
			Date date_depot) {
		super();
		this.id_proposition = id_proposition;
		this.titre = titre;
		this.description = description;
		this.technologie = technologie;
		this.fichier = fichier;
		this.date_depot = date_depot;
	}
	public Long getId_proposition() {
		return id_proposition;
	}
	public void setId_proposition(Long id_proposition) {
		this.id_proposition = id_proposition;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTechnologie() {
		return technologie;
	}
	public void setTechnologie(String technologie) {
		this.technologie = technologie;
	}
	public String getFichier() {
		return fichier;
	}
	public void setFichier(String fichier) {
		this.fichier = fichier;
	}
	public Date getDate_depot() {
		return date_depot;
	}
	public void setDate_depot(Date date_depot) {
		this.date_depot = date_depot;
	}
    
	




}
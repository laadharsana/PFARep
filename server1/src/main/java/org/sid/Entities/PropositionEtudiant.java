package org.sid.Entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement

@Entity
@Table(name = "PropositionEtudiant")
public class PropositionEtudiant extends Proposition implements Serializable {
	private float affecte=(float)0;
	private boolean dispo = true ;
	public boolean isDispo() {
		return dispo;
	}
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
	@ManyToOne
    @JoinColumn
    private Etudiant etudiant;
	public PropositionEtudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PropositionEtudiant(Long id_proposition, String titre, String description, String technologie,
			String fichier, Date date_depot) {
		super(id_proposition, titre, description, technologie, fichier, date_depot);
		// TODO Auto-generated constructor stub
	}
	public PropositionEtudiant(float affecte, Etudiant etudiant) {
		super();
		this.affecte = affecte;
		this.etudiant = etudiant;
	}
	public float getAffecte() {
		return affecte;
	}
	public void setAffecte(float affecte) {
		this.affecte = affecte;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

}

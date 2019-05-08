package org.sid.Entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.sid.Entities.Enseignant;
import org.sid.Entities.Proposition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@Entity
@Table(name = "PropositionEnseignant")
public class PropositionEnseignant extends Proposition implements Serializable {
	private float affecte=(float) 0.5;
	private boolean dispo=true ; 
	
	public boolean isDispo() {
		return dispo;
	}
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

	@ManyToOne
    @JoinColumn
    private Enseignant enseignant;
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public PropositionEnseignant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropositionEnseignant(Long id_proposition, String titre, String description, String technologie,
			String fichier, Date date_depot) {
		super(id_proposition, titre, description, technologie, fichier, date_depot);
		// TODO Auto-generated constructor stub
	}
	public PropositionEnseignant(float affecte, Enseignant enseignant) {
		super();
		this.affecte = affecte;
		this.enseignant = enseignant;
	}
	public float getAffecte() {
		return affecte;
	}
	public void setAffecte(float affecte ) {
		this.affecte = affecte;
	}
	public void accepterProposition() {
		this.affecte=1;
	}

	public void refuserProposition() {
		this.affecte=0;
	}
}



package org.sid.Entities;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name = "Etudiant")
public class Etudiant extends Users implements Serializable {
	
    private boolean affecte ;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "etudiant_section", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "id_section"	))
    private Set<Section> section;
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etudiant(String email, String password, String name, String lastName, Date birthday, int status,
			String username) {
		super(email, password, name, lastName, birthday, status, username);
		// TODO Auto-generated constructor stub
	}
	public Etudiant(Users users) {
		super(users);
		// TODO Auto-generated constructor stub
	}
	public Etudiant(String email, String password, String name, String lastName, Date birthday, int status,
			String username, boolean affecte, Set<Section> section) {
		super(email, password, name, lastName, birthday, status, username);
		this.affecte = affecte;
		this.section = section;
	}
	public boolean isAffecte() {
		return affecte;
	}
	public void setAffecte(boolean affecte) {
		this.affecte = affecte;
	}
	public Set<Section> getSection() {
		return section;
	}
	public void setSection(Set<Section> section) {
		this.section = section;
	}
    
    
	
}
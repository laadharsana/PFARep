package org.sid.Entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.context.annotation.Primary;

@Entity
@Table(name = "Enseignant")
public class Enseignant extends Users implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "user_id")
    private  long  id;

	private int nombreProp = 5;
    private int nombrePropRestant = 5;
    private boolean dispo=true;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "enseignant_specialite", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "id_specialte"	))
    private Set<Specialite> specialite;
    
    
    
public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNombreProp() {
		return nombreProp;
	}
	public void setNombreProp(int nombreProp) {
		this.nombreProp = nombreProp;
	}
	public int getNombrePropRestant() {
		return nombrePropRestant;
	}
	public void setNombrePropRestant(int nombrePropRestant) {
		this.nombrePropRestant = nombrePropRestant;
	}
	public boolean isDispo() {
		return dispo;
	}
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
	public Set<Specialite> getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Set<Specialite> specialite) {
		this.specialite = specialite;
	}
public Enseignant(String email, String password, String name, String lastName, Date birthday, int status,
			String username, int id, int nombreProp, int nombrePropRestant, boolean dispo,
			Set<Specialite> specialite) {
		super(email, password, name, lastName, birthday, status, username);
		this.id = id;
		this.nombreProp = nombreProp;
		this.nombrePropRestant = nombrePropRestant;
		this.dispo = dispo;
		this.specialite = specialite;
	}
public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enseignant(String email, String password, String name, String lastName, Date birthday, int status,
			String username) {
		super(email, password, name, lastName, birthday, status, username);
		// TODO Auto-generated constructor stub
	}
	public Enseignant(Users users) {
		super(users);
		// TODO Auto-generated constructor stub
	}
public void diminuerNbreRestant() {
	 int x=this.getNombrePropRestant();
	 setNombrePropRestant(x-1);
	
}
public void augmenterNbreRestant() {
	 int x=this.getNombrePropRestant();
	 setNombrePropRestant(x+1);
	
}

}
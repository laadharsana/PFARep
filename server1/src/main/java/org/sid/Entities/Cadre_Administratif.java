package org.sid.Entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Cadre_Administratif")
public class Cadre_Administratif extends Users {
	
private String position;

public Cadre_Administratif() {
	// TODO Auto-generated constructor stub
}

public Cadre_Administratif(String email, String password, String name, String lastName, Date birthday, int status,String username) {
	super(email, password, name, lastName, birthday, status, username);
	// TODO Auto-generated constructor stub
}

public Cadre_Administratif(String position) {
	super();
	this.position = position;
}

public String getPosition() {
	return position;
}

public void setPosition(String position) {
	this.position = position;
} 
}

package org.sid.Entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin extends Users {

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String email, String password, String name, String lastName, Date birthday, int status,
			String username) {
		super(email, password, name, lastName, birthday, status, username);
		// TODO Auto-generated constructor stub
	}
	
}

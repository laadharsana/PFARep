package org.sid.Entities;

import java.util.Date;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;



import javax.persistence.InheritanceType;


@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)


public class Users {

  
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "user_id")
    private long  id;
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @NotEmpty(message = "username not empty")
    @Column(name = "username")

    private String username;
    @Column(name = "name")
    @NotEmpty
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthday")
    private Date birthday; 
    @Column(name = "status")
    private int status;
    /*
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
*/
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", 
      joinColumns = @JoinColumn(name = "user_id"), 
      inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role = new HashSet<>();
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public String getUserName() {
		return username;
	}
	public Users(String email, String password, String name, String lastName, Date birthday, int status,
		 String username) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.birthday = birthday;
		this.status = status;
		this.username = username;
	}

public Users () {}
	public Users(Users users) {
	
		this.email = users.getEmail();
		this.password =users.getPassword();
		this.name = users.getName();
		this.username = users.getUserName();
		this.lastName = users.getLastName();
		this.birthday = users.getBirthday();
		this.status = users.getStatus();
		this.role = users.getRoles();
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Set<Role> getRoles() {
		return role;
	}
	public void setRoles(Set<Role> roles) {
		this.role = roles;
	}

}
package org.sid.repository;

import java.util.Optional;


import org.sid.Entities.Admin;
import org.sid.Entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
public interface AdminRepository extends JpaRepository<Admin, Long> {
	  Optional<Admin> findByUsername(String username);
	    Boolean existsByUsername(String username);
	    Boolean existsByEmail(String email);
	
}

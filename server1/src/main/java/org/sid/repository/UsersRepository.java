package org.sid.repository;

import java.util.Optional;


import org.sid.Entities.Users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface  UsersRepository extends JpaRepository<Users, Long>{

	   Optional<Users> findByUsername(String username);
	    Boolean existsByUsername(String username);
	    Boolean existsByEmail(String email);

}

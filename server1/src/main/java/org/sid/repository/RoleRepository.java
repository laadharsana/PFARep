package org.sid.repository;

import java.util.Optional;


import org.sid.Entities.Role;
////import org.sid.Entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  RoleRepository extends JpaRepository<Role, String>{

	
Optional<Role> findByName(String roleName);
}

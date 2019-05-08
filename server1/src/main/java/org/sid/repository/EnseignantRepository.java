package org.sid.repository;

import java.util.List;

import org.sid.Entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{
	@Query("select u from Enseignant u where u.nombrePropRestant > 0")
    List<Enseignant> ListeEnsDispo() ;
	
}

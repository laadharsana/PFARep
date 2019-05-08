package org.sid.repository;

import org.sid.Entities.Cadre_Administratif;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CadreRepository extends JpaRepository<Cadre_Administratif, Long> {

}

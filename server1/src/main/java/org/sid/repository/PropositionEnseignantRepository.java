package org.sid.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.sid.Entities.Enseignant;
import org.sid.Entities.Etudiant;
import org.sid.Entities.Proposition;
import org.sid.Entities.PropositionEnseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import java.util.*;
public interface PropositionEnseignantRepository extends JpaRepository<PropositionEnseignant, Long> {
	@Query("select u from PropositionEnseignant u where u.affecte = 1")
    List<PropositionEnseignant> propositionEnseignantValide() ;
	@Transactional
	@Modifying
	/*@Query("update PropositionEnseignant u set u.affecte = 1  where u.id_proposition = :id")
	void approuver(  @Param("id") Long id);
	@Transactional
	@Modifying
	@Query("update PropositionEnseignant u set u.affecte = 0  where u.id_proposition = :id")
	void disapprouver (  @Param("id") Long id);*/
	
	 @Query("select u from PropositionEnseignant u where u.affecte = 0")
	 List<PropositionEnseignant> propositionEnseignantInValide() ;
	 @Query("select u from PropositionEnseignant u where u.affecte = 0.5")
	 List<PropositionEnseignant> propositionEnseignantEnAttente() ;
	 @Query("select u from PropositionEnseignant u where u.affecte = 1")
	 List<PropositionEnseignant> propositionEnseignantAccepte() ;
	 @Query("select u from PropositionEnseignant u where u.dispo = true")
	 List<PropositionEnseignant> findAllDispo() ;
	
	 /*afficher les details de l'enseignant pour une prop*/
	 @Query("select u.enseignant from PropositionEnseignant u where u.id_proposition= :id")
	 Enseignant DetailEnseignant(@Param("id") Long id) ;
	 
	 
}


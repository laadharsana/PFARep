package org.sid.repository;
import org.sid.Entities.Enseignant;
import org.sid.Entities.Etudiant;
import org.sid.Entities.PropositionEnseignant;
import org.sid.Entities.PropositionEtudiant;

import java.util.List;

import org.sid.repository.PropositionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface PropositionEtudiantRepository<PropositionEtudiant, Long> extends PropositionRepository {
   @Query("select u from PropositionEtudiant u where u.affecte = 1")
    List<PropositionEtudiant> propositionEtudiantValide() ;
   @Query("select u from PropositionEtudiant u where u.affecte = 0 and u.dispo=false")
   List<PropositionEtudiant> propositionEtudiantInValide() ;
   @Query("select u from PropositionEtudiant u where u.affecte = 0 and u.dispo=true")
   List<PropositionEtudiant> propositionEtudiantEnAttente() ;
   @Query("select u from PropositionEtudiant u where u.affecte=0.5")
   List<PropositionEtudiant> propositionEtudiantPourCadre() ;
   /*
   @Transactional
	@Modifying
	@Query("update PropositionEtudiant u set u.affecte = 0.5 where u.id_proposition = :id")
	void affecte_demi (  @Param("id") Long id);
	
	
	@Transactional
	@Modifying
	@Query("update PropositionEtudiant u set u.affecte = 1 where u.id_proposition = :id")
	void affecte_final (  @Param("id") Long id);
	@Transactional
	@Modifying
	@Query("update PropositionEtudiant u set u.affecte = 0  where u.id_proposition = :id")
	void disapprouver (  @Param("id") Long id);*/
	
   
   
	@Query("select u.etudiant from PropositionEtudiant u where u.affecte = 0")
	 List<Etudiant> ListeEtudiantPropInValide() ;
	 @Query("select u.etudiant from PropositionEtudiant u where u.affecte = 1")
	 List<Etudiant> ListeEtudiantPropValide() ;
	 /*afficher les details de l'enseignant pour une prop*/
	 
	 @Query("select u.etudiant from PropositionEtudiant u where u.id_proposition= :id")
	 Etudiant DetailEtudiant(@Param("id") Long id) ;
	 
	 
	
}

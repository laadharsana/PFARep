package org.sid.Controllers;
import java.io.Serializable;
import java.util.List;

import org.sid.repository.PropositionEtudiantRepository;
import org.sid.Entities.Enseignant;
import org.sid.Entities.Etudiant;
import org.sid.Entities.Proposition;
import org.sid.Entities.PropositionEnseignant;
import org.sid.Entities.PropositionEtudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin( "*")
public class PropositionEtudiantController implements Serializable {
	/* CRUD Prop Etudiant */
	@Autowired
	private 	PropositionEtudiantRepository propositionetudiantRepository;
	@RequestMapping(value="api/auth/Propositionetudiant",method=RequestMethod.GET)	
     public List<Proposition> getPropositionetudiant(){
    	return propositionetudiantRepository.findAll();
    }
	@RequestMapping(value="api/auth/FindPropositionetudiant/{id}",method=RequestMethod.GET)	
	   public PropositionEtudiant getPropositionetudiant(@PathVariable Long id){
		return (PropositionEtudiant) propositionetudiantRepository.findById(id).orElse(null);
	}
	
	@RequestMapping(value="api/auth/SupPropositionetudiant/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		propositionetudiantRepository.deleteById(id);	
		return true;
		}
	@RequestMapping(value="api/auth/save/propEtudiant",method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public PropositionEtudiant save(@RequestBody PropositionEtudiant p) {
		return propositionetudiantRepository.save(p);
	}
   /*
    @RequestMapping(value="/UpdatePropositionetudiant/{id}",method=RequestMethod.PUT)
		public PropositionEtudiant update (@PathVariable Long id,@RequestBody PropositionEtudiant p ){ 
			 ((Proposition) p).setId(id);
			return propositionetudiantRepository.save(p);
}			*/
	
	
	
	
	/* Approuver / disaprouver Prop Etudiant */
	@RequestMapping(value="api/auth/approuverPropEtudiantParEnseignant/{id}",method=RequestMethod.PUT)
	
	public void approuver(@PathVariable Long id ,@RequestBody PropositionEtudiant p) {
		 p.setAffecte(((float)0.5));
		  p.setDispo(false);
		  propositionetudiantRepository.save(p);
	}
	@RequestMapping(value="api/auth/DisapprouverPropEtudiant/{id}",method=RequestMethod.PUT)
	public void disapprouver(@PathVariable Long id ,@RequestBody PropositionEtudiant p) {
		 p.setAffecte(0);
		 p.setDispo(false);
		 propositionetudiantRepository.save(p);
	}

	@RequestMapping(value="api/auth/approuverPropEtudiantParCadreAdmin/{id}",method=RequestMethod.PUT)
	public void approuver_final(@PathVariable Long id ,@RequestBody PropositionEtudiant p) {
		 p.setAffecte(1);
		 propositionetudiantRepository.save(p);
	}
	
	/* Liste -------des Propositions ------Etudiant Valide/Invalide */ 
	
	@RequestMapping(value="api/auth/PropEtudiantValide",method=RequestMethod.GET)
	 public List<PropositionEtudiant> getPropositionetudiantvalide(){
    	return propositionetudiantRepository.propositionEtudiantValide();
	}
	
	
	/****Afficher Pour le cadre ****/
	@RequestMapping(value="api/auth/PropEtudiantInValide",method=RequestMethod.GET)
	 public List<PropositionEtudiant> getPropositionetudiantInvalide(){
     	return propositionetudiantRepository.propositionEtudiantInValide();  
	}
   @RequestMapping(value="api/auth/PropEtudiantPourCadre",method=RequestMethod.GET)
   	 public List<PropositionEtudiant> getPropositionetudiantSemiValide(){
       	return propositionetudiantRepository.propositionEtudiantPourCadre();
   	}
     	
	/****Afficher Pour l'enseignant ****/
	@RequestMapping(value="api/auth/PropEtudiantEnAttente",method=RequestMethod.GET)
	 public List<PropositionEtudiant> getPropositionetudiantEnAttente(){
    	return propositionetudiantRepository.propositionEtudiantEnAttente(); 	
	}
	

    /* Liste------ Des Etudiants--- avec Proposition Valide /Invalide */
     @RequestMapping(value="api/auth/ListeEtudiantPropValide",method=RequestMethod.GET)
   	 public List<Etudiant> getListePropositionetudiantvalide(){
       	return propositionetudiantRepository.ListeEtudiantPropValide();
   	}
   	@RequestMapping(value="api/auth/ListeEtudiantPropInValide",method=RequestMethod.GET)
   	 public List<Etudiant> getListePropositionetudiantInvalide(){
        	return propositionetudiantRepository.ListeEtudiantPropInValide();}
        	
        	/***----- detail de l'etudiant qui a une proposition--------****/
       
   	@RequestMapping(value="api/auth/DetailEtudiantParProp/{id}",method=RequestMethod.GET)
         	public Etudiant detailEtudiant(@PathVariable Long id) {
         		return propositionetudiantRepository.DetailEtudiant(id) ; }

}


package org.sid.Controllers;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.sid.repository.PropositionEnseignantRepository;
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
public class PropositionEnseignantController implements Serializable {
	@Autowired
	private 	PropositionEnseignantRepository propositionEnseignantRepository;
	
	@RequestMapping(value="api/auth/AllPropositionEnseignant",method=RequestMethod.GET)	
     public List<PropositionEnseignant>getPropositionEnseignant(){
    	return propositionEnseignantRepository.findAll();
    }
	@RequestMapping(value="api/auth/PropositionEnseignant",method=RequestMethod.GET)	
    public List<PropositionEnseignant>PropositionDispo(){
   	return propositionEnseignantRepository.findAllDispo();
   }
   
	@RequestMapping(value="api/auth/FindPropositionEnseignant/{id}",method=RequestMethod.GET)	
	   public PropositionEnseignant getPropositionEnseignant(@PathVariable Long id){
		return propositionEnseignantRepository.findById(id).orElse(null);
	}

	
	@RequestMapping(value="api/auth/SupPropositionEnseignant/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		propositionEnseignantRepository.deleteById(id);	
		return true;
		}
	@RequestMapping(value="api/auth/save/propEns",method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public PropositionEnseignant save(@RequestBody PropositionEnseignant p) {
		return propositionEnseignantRepository.save(p);
	}

	
	
			/*-----------Approuver/desapprouver Proposition Enseignant ------------*/
	
	@RequestMapping(value="api/auth/approuverPropEnseignant/{id}",method=RequestMethod.PUT)
	public void approuver(@PathVariable Long id ,@RequestBody PropositionEnseignant p) {
		  p.setAffecte(1);
		  p.setDispo(false);
		  propositionEnseignantRepository.save(p);
	}
	@RequestMapping(value="api/auth/disapprouverPropEnseignant/{id}",method=RequestMethod.PUT)
	public void disapprouver(@PathVariable Long id,@RequestBody PropositionEnseignant p) {
		p.setAffecte(0);
		p.setDispo(false);
	    propositionEnseignantRepository.save(p);
	}
	
		  
		  
		  /*---------Proposition Enseignant Valide/Invalide---------*/
	
	@RequestMapping(value="api/auth/PropEnseignantAccepte",method=RequestMethod.GET)
	 public List<PropositionEnseignant> getPropositionetudiantvalide(){
   	return propositionEnseignantRepository.propositionEnseignantAccepte();
   }
	@RequestMapping(value="api/auth/PropEnseignantInValide",method=RequestMethod.GET)
	 public List<PropositionEnseignant> getPropositionetudiantInvalide(){
  	return propositionEnseignantRepository.propositionEnseignantInValide(); 		
  }
	@RequestMapping(value="api/auth/PropEnseignantEnAttente",method=RequestMethod.GET)
	 public List<PropositionEnseignant> getPropositionetudiantEnAttente(){
 	return propositionEnseignantRepository.propositionEnseignantEnAttente();
  }
 	/***----- detail de l'enseignant qui a une proposition--------****/
	@RequestMapping(value="api/auth/DetailEnseignantParProp/{id}",method=RequestMethod.GET)
 	public Enseignant detailEnseignant(@PathVariable Long id) {
 		return propositionEnseignantRepository.DetailEnseignant(id) ;
 	}
}


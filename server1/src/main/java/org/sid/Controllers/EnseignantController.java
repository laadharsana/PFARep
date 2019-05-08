package org.sid.Controllers;

import java.util.List;

import org.sid.Entities.Admin;
import org.sid.Entities.Enseignant;
import org.sid.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.sid.repository.EnseignantRepository;
import org.sid.Entities.Enseignant;
import org.sid.Entities.Etudiant;
import org.sid.Entities.PropositionEnseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin( "*")
public class EnseignantController {
	/*------ CRUD ----*/
	@Autowired
	private 	EnseignantRepository enseignantRepository;
	
	@RequestMapping(value="api/auth/Allenseignant",method=RequestMethod.GET)	
     public List<Enseignant>getenseignant(){
    	return enseignantRepository.findAll();
    }
   
	@RequestMapping(value="api/auth/enseignant/{id}",method=RequestMethod.GET)	
	   public Enseignant getenseignant(@PathVariable Long id){
		return enseignantRepository.findById(id).orElse(null);
	}
	
	@RequestMapping(value="api/auth/Deleteenseignant/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		enseignantRepository.deleteById(id);	
		return true;
		}
	@RequestMapping(value="api/auth/saveEnseignant",method=RequestMethod.POST)
	public Enseignant save(@RequestBody Enseignant p) {
		return enseignantRepository.save(p);
	}
   
    @RequestMapping(value="api/auth/Updateenseignant/{id}",method=RequestMethod.PUT)
		public Enseignant update (@PathVariable Integer id,@RequestBody Enseignant p ){ 
			p.setId(id);
			return enseignantRepository.save(p);
			
}
    /*---------diminuer/augmenter le nbre des props restant-----------*/
    
    @RequestMapping(value="api/auth/DiminuerNbrePropRestant/{id}",method=RequestMethod.PUT)
	public void diminuer(@PathVariable Long id,@RequestBody Enseignant p) {
		p.diminuerNbreRestant();
	    enseignantRepository.save(p);
	}
    @RequestMapping(value="api/auth/AugmenterNbrePropRestant/{id}",method=RequestMethod.PUT)
 	public void augmenter(@PathVariable Long id,@RequestBody Enseignant p) {
 		p.augmenterNbreRestant();
 	    enseignantRepository.save(p);
 	}
	
    /*-------------------- Liste des enseignant Dispos -----*/ 
    @RequestMapping(value="api/auth/ListeEnseignantDispo",method=RequestMethod.GET)
  	 public List<Enseignant> getListeEnsDispo(){
       	return enseignantRepository.ListeEnsDispo(); }
    
    
}
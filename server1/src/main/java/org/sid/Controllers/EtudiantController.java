package org.sid.Controllers;

import java.util.List;

import org.sid.repository.EtudiantRepository;
import org.sid.Entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin( "*")
public class EtudiantController {
	@Autowired
	private 	EtudiantRepository etudiantRepository;
	
	@RequestMapping(value="api/auth/Alletudiant",method=RequestMethod.GET)	
     public List<Etudiant>getetudiant(){
    	return etudiantRepository.findAll();
    }
   
	@RequestMapping(value="api/auth/etudiant/{id}",method=RequestMethod.GET)	
	   public Etudiant getetudiant(@PathVariable Long id){
		return etudiantRepository.findById(id).orElse(null);
	}
		

	
	@RequestMapping(value="api/auth/Deleteetudiant/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		etudiantRepository.deleteById(id);	
		return true;
		}
	@RequestMapping(value="api/auth/saveetudiant",method=RequestMethod.POST)
	public Etudiant save(@RequestBody Etudiant p) {
		return etudiantRepository.save(p);
	}
   
    @RequestMapping(value="api/auth/Updateetudiant/{id}",method=RequestMethod.PUT)
		public Etudiant update (@PathVariable Integer id,@RequestBody Etudiant p ){ 
			p.setId(id);
			return etudiantRepository.save(p);
			
}
}
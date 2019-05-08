package org.sid.Controllers;

import java.util.List;

import org.sid.repository.SpecialiteRepository;
import org.sid.Entities.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin( "*")
public class SpecialiteController {
	@Autowired
	private 	SpecialiteRepository specialiteRepository;
	
	@RequestMapping(value="api/auth/AllSpecialite",method=RequestMethod.GET)	
     public List<Specialite>getSpecialite(){
    	return specialiteRepository.findAll();
    }
   
	@RequestMapping(value="api/auth/Specialite/{id}",method=RequestMethod.GET)	
	   public Specialite getSpecialite(@PathVariable Long id){
		return specialiteRepository.findById(id).orElse(null);
	}
		

	
	@RequestMapping(value="api/auth/DeleteSpecialite/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		specialiteRepository.deleteById(id);	
		return true;
		}
	@RequestMapping(value="api/auth/saveSpecialite",method=RequestMethod.POST)
	public Specialite save(@RequestBody Specialite p) {
		return specialiteRepository.save(p);
	}
   
    @RequestMapping(value="api/auth/UpdateSpecialite/{id}",method=RequestMethod.PUT)
		public Specialite update (@PathVariable Long id,@RequestBody Specialite p ){ 
			p.setId_specialte(id);
			return specialiteRepository.save(p);
			

}}
